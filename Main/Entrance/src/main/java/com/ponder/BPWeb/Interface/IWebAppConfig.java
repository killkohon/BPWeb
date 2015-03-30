/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ponder.BPWeb.Interface;

import org.osgi.service.http.HttpContext;

/**
 *
 * @author Administrator
 */
public interface IWebAppConfig {
    public boolean registerStaticResources(String UrlPath,String RealPath);
    public boolean registerStaticResources(String UrlPath,String RealPath,HttpContext httpcontext);
    public void unregisterStaticResources(String UrlPath);
}
