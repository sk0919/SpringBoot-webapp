/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.support.supportapis.constant;

/**
 *
 * @author <Sumit Mishra>
 */
public interface SupportApisConstant {
    
    public static final String SUCCESS = "SUCCESS";
    
    public static final String FAILED = "FAILED";
    
    public static final String DONE = "DONE";
    
    public static final int SUCCESS_STATUS_CODE = 200;
    public static final String SUCCESS_STATUS_MESSAGE = "Successfully retrieved list";
    
    public static final String INTERNAL_SERVER_ERROR = "Internal error";
    
    public static final String UNAUTHORISED_STATUS_MESSAGE = "You are not authorized to view the resource";
    public static final int UNAUTHORISED_STATUS_CODE = 401;
    
    public static final String FORBIDDEN_STATUS_MESSAGE = "Accessing the resource you were trying to reach is forbidden";
    public static final int FORBIDDEN_STATUS_CODE = 403;
    
    public static final String NOT_FOUND_STATUS_MESSAGE = "The resource you were trying to reach is not found";
    public static final int NOT_FOUND_STATUS_CODE = 404;
    
    public static final String INTERNAL_ERROR_STATUS_MESSAGE = "Internal error occurred";
    public static final int INTERNAL_ERROR_STATUS_CODE = 503;
    
    public static final String UPDATE_DATA_STATUS_MESSAGE = "Updated successfully";
    public static final int UPDATE_DATA_ERROR_STATUS_CODE = 204;
    
}
