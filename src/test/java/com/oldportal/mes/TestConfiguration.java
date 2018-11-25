/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes;

import com.oldportal.mes.config.WebAppConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring App configuration for unit tests.
 * 
 * @author Dmitry Ognyannikov
 */
@Configuration
@EnableAutoConfiguration(exclude={org.activiti.spring.boot.SecurityAutoConfiguration.class})
@ComponentScan
@EnableTransactionManagement
@Import(WebAppConfiguration.class)
@ImportResource("classpath:connections-test.xml")
public class TestConfiguration {
    
}
