/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ponder.UISystem.BPWeb;

import java.io.IOException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.osgi.service.blueprint.container.BlueprintContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Killko Hon
 */
public class MainServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(MainServlet.class);
    protected static CamelContext camel;

    protected static ProducerTemplate producer;

    @Override
    public void init() throws ServletException {
        super.init();
        if (Activator.camelContextTracker != null) {
            Activator.camelContextTracker.open();
        }
    }

    ;
    

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (camel == null) {
            response.setContentType("text/plain;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Connection", "close");
            response.getWriter().write("Failure!");
        } else {
            if (producer != null) {
                Exchange exchange = camel.getEndpoint("vm:BPWebMainQueue").createExchange();
                exchange.setPattern(ExchangePattern.InOut);             //设置为同步
                exchange.getIn().setBody(request);
                producer.send("vm:BPWebMainQueue", exchange);
                response.setContentType("text/plain;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setHeader("Connection", "close");
                response.getWriter().write("success!");
            } else {
                response.setContentType("text/plain;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setHeader("Connection", "close");
                response.getWriter().write("No producer!");
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
