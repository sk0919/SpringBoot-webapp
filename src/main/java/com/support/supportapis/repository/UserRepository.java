/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.support.supportapis.repository;

import com.support.supportapis.entity.UserEntity;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author <Sumit Mishra>
 */
@Repository
//@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    
    /**
     *
     * @param userEntity
     * @return UserEntity
     */
    @Override
    UserEntity save(UserEntity userEntity);
}
