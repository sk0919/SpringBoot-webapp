/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.support.supportapis.service.impl;

import com.support.supportapis.entity.UserEntity;
import com.support.supportapis.repository.UserRepository;
import com.support.supportapis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author <Sumit Mishra>
 */
@Service(value="userservice")
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository userRepo;
    
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    
    /**
     *
     * @param userEntity
     * @return UserEntity
     */
    @Override
    public UserEntity createUser(UserEntity userEntity) {
        
        try{
            LOGGER.info("=================================");
            LOGGER.info(userEntity.toString());
            LOGGER.info("=================================");
            //userEntity = userRepo.save(userEntity);
            userEntity = userRepo.save(userEntity);
        }catch(Throwable t){
            LOGGER.error(t.getMessage());
        }
        return userEntity;
    }
}
