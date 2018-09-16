/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes;

import com.oldportal.mes.config.WebAppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application start point.
 * 
 * @author Dmitry Ognyannikov
 */
@SpringBootApplication(exclude={org.activiti.spring.boot.SecurityAutoConfiguration.class})
@EnableTransactionManagement
//@EnableGlobalMethodSecurity
@Import(WebAppConfiguration.class)
@ImportResource("classpath:connections.xml")
public class Application extends WebMvcAutoConfiguration {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

}
