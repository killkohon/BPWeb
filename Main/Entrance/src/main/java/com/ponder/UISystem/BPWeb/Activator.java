/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ponder.UISystem.BPWeb;

import org.apache.camel.CamelContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.blueprint.container.BlueprintContainer;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Killko Hon
 */
public class Activator implements BundleActivator {

    private static final Logger log = LoggerFactory.getLogger(Activator.class);
    protected static ServiceTracker camelContextTracker;

    @Override
    public void start(BundleContext context) throws Exception {
        camelContextTracker = new ServiceTracker(context, CamelContext.class.getName(), null) {
            @Override
            public void removedService(ServiceReference reference, Object service) {
               MainServlet.camel =null; 
               MainServlet.producer=null;
            }

            @Override
            public Object addingService(ServiceReference reference) {
                // HTTP service is available, register our resources...
                CamelContext camelContext = (CamelContext) this.context.getService(reference);
                
                if(camelContext!=null){
                    for(String a:camelContext.getComponentNames()){
                    System.out.println(a);
                    }
                MainServlet.camel = camelContext;
                MainServlet.producer=camelContext.createProducerTemplate();
                }
                return camelContext;
            }
        };
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        camelContextTracker=null;
    }
}
