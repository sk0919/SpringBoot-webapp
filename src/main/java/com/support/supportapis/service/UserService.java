/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.support.supportapis.service;

import com.support.supportapis.entity.UserEntity;

/**
 *
 * @author <Sumit Mishra>
 */
public interface UserService  {
    
    public UserEntity createUser(UserEntity userEntity);
}
