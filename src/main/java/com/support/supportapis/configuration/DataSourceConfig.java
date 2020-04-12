/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.support.supportapis.configuration;

import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author <Sumit Mishra>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.support.supportapis.repository")
public class DataSourceConfig {
    
    @Value("${webapp.datasource.driver.classname}")
    private String pgDriverClass;
    
    @Value("${webapp.spring.datasource.username}")
    private String pgUserName;
    
    @Value("${webapp.spring.datasource.password}")
    private String pgPassword;
    
    @Value("${webapp.datasource.jdbcurl}")
    private String pgJdbcUrl;
    
    @Value("${webapp.services.hikari.maximum-pool-size}")
    private int pgMaxPool;
    
    @Value("${webapp.services.hikari.minimumIdle}")
    private int pgMinIdle;
    
    @Value("${webapp.hikari.poolname}")
    private String hikariPoolName;
    
    @Value("${webapp.hikari.enable.hikari.pool}")
    private Boolean enableHikariPool;
    
    @Autowired
    Environment environment;
    
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder.create().build();
        
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setJdbcUrl(pgJdbcUrl);
        dataSource.setUsername(pgUserName);
        dataSource.setPassword(pgPassword);
        dataSource.setPoolName(hikariPoolName);
        dataSource.setMinimumIdle(pgMinIdle);
        dataSource.setMaximumPoolSize(pgMaxPool);


        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.support.supportapis.entity");
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        em.setPersistenceUnitName("supportserviceentry");

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        properties.put("hibernate.temp.use_jdbc_metadata_defaults","false");
        properties.put("hibernate.show_sql", "true");
        //properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.connection.release_mode", "after_transaction");
        properties.put("hibernate.order_inserts", "true");
        properties.put("hibernate.order_updates", "true");
        properties.put("hibernate.jdbc.batch_size", "25");
        return properties;
    }
    
}
