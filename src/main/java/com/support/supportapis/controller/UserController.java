/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.support.supportapis.controller;

import static com.support.supportapis.constant.SupportApisConstant.FORBIDDEN_STATUS_CODE;
import static com.support.supportapis.constant.SupportApisConstant.FORBIDDEN_STATUS_MESSAGE;
import static com.support.supportapis.constant.SupportApisConstant.INTERNAL_ERROR_STATUS_CODE;
import static com.support.supportapis.constant.SupportApisConstant.INTERNAL_ERROR_STATUS_MESSAGE;
import static com.support.supportapis.constant.SupportApisConstant.NOT_FOUND_STATUS_CODE;
import static com.support.supportapis.constant.SupportApisConstant.NOT_FOUND_STATUS_MESSAGE;
import static com.support.supportapis.constant.SupportApisConstant.SUCCESS_STATUS_CODE;
import static com.support.supportapis.constant.SupportApisConstant.SUCCESS_STATUS_MESSAGE;
import static com.support.supportapis.constant.SupportApisConstant.UNAUTHORISED_STATUS_CODE;
import static com.support.supportapis.constant.SupportApisConstant.UNAUTHORISED_STATUS_MESSAGE;
import com.support.supportapis.entity.UserEntity;
import com.support.supportapis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <Sumit Mishra>
 */
@RestController
@RequestMapping("/user")
@Api(value="usercontroller", description="Get User info like username,id,address,account_status... etc")
public class UserController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    UserService userService;
    
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS_STATUS_CODE, message = SUCCESS_STATUS_MESSAGE),
        @ApiResponse(code = UNAUTHORISED_STATUS_CODE, message = UNAUTHORISED_STATUS_MESSAGE),
        @ApiResponse(code = FORBIDDEN_STATUS_CODE, message = FORBIDDEN_STATUS_MESSAGE),
        @ApiResponse(code = NOT_FOUND_STATUS_CODE, message = NOT_FOUND_STATUS_MESSAGE),
        @ApiResponse(code = INTERNAL_ERROR_STATUS_CODE, message = INTERNAL_ERROR_STATUS_MESSAGE)
    })
  
    @RequestMapping(method = RequestMethod.GET ,value = "/v1/user")
    public String testUser(){
        LOGGER.info("-----------testing------------");
        return "we are insdide the user controller";
    }
    
    
    
    
    @PostMapping(value="/v1/createUser/", 
            consumes="application/json", produces = "application/json")
    public ResponseEntity<UserEntity> createUser(@ApiParam(value = "Create new entry for User", required = true)
           @RequestBody UserEntity userEntity){
        LOGGER.info("--------------------entered--------------------");
        LOGGER.info("=================================");
        LOGGER.info(userEntity.toString());
        LOGGER.info("=================================");
        LOGGER.info("--------------------entered--------------------");
        UserEntity userVo = userService.createUser(userEntity);
        return new ResponseEntity<>(userVo, new HttpHeaders(), HttpStatus.OK);
    }
    
    
    
}
