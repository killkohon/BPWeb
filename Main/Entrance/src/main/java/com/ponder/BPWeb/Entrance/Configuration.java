/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ponder.BPWeb.Entrance;

import com.ponder.BPWeb.Interface.IWebAppConfig;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Killko Hon
 */
public class Configuration implements IWebAppConfig{
    private static final Logger log = LoggerFactory.getLogger(Configuration.class);
    private HttpService httpService;

    public HttpService getHttpService() {
        return httpService;
    }

    public void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }
    
    
    @Override
    public boolean registerStaticResources(String UrlPath, String RealPath) {
        try {
            httpService.registerResources(UrlPath, RealPath, null);
            return true;
        } catch (NamespaceException ex) {
            return false;
        }
    }

    @Override
    public boolean registerStaticResources(String UrlPath, String RealPath, HttpContext httpcontext) {
        try {
            httpService.registerResources(UrlPath, RealPath, httpcontext);
            return true;
        } catch (NamespaceException ex) {
            return false;
        }
    }

    @Override
    public void unregisterStaticResources(String UrlPath) {
        httpService.unregister(UrlPath);
    }
}
