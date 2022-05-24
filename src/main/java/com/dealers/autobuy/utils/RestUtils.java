package com.dealers.autobuy.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.dealers.autobuy.json.JsonResult;

/**
 * Utility for Application rest operations
 * @author Ali Golkar
 */
public class RestUtils <T> {

    @Autowired
    public T service;

    public JsonResult jsonResult;

    public RestUtils() {
    }

    public T getService() {
        return service;
    }

    public void setService(T service) {
        this.service = service;
    }
}
