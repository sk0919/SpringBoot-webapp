/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.support.supportapis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author <Sumit Mishra>
 */
@Data
@Entity
@Table(name="users", schema="public")
@JsonIgnoreProperties(value = {"date_created", "date_updated"},allowGetters = true)
public class UserEntity implements Serializable{
    
    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "users_id",updatable = false)
    private Integer userId;
    
    @Column(name = "user_profile_name")
    private String userProfileName;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "middle_name")
    private String middleName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "zipcode")
    private String zipcode;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "status")
    private String status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_updated", nullable = false)
    @LastModifiedDate
    private Date modifiedDate;
    
}
