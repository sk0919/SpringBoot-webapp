/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.support.supportapis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <Sumit Mishra>
 */
@RestController
@RequestMapping("/")
public class TestWebApplicationController {
    
    @RequestMapping(method = RequestMethod.GET, value = "/v1/test")
    public String testWebApp(){
        return "Application running ..!";
    }
    
    
}
