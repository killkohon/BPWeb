/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ponder.BPWeb.ModuleA;

import javax.servlet.http.HttpServletRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Killko Hon
 */
public class helloWorld implements Processor{
    private static final Logger log = LoggerFactory.getLogger(helloWorld.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        HttpServletRequest request=exchange.getIn().getBody(HttpServletRequest.class);
        String name=request.getParameter("name");
        if(name==null){
            name="";
        }
        exchange.getOut().setHeader("MimeType", "text/html");
        exchange.getOut().setBody("<html><body><h1>Hello!"+name+"</h1></body></html>");
    }
}
