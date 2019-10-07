/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes;

import com.oldportal.mes.config.WebAppConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring App configuration for unit tests.
 *
 * @author Dmitry Ognyannikov
 */
@Configuration
@EnableWebMvc
//@EnableAutoConfiguration(exclude = {Application.class})
@ImportResource("classpath:connections-test.xml")
@Import(WebAppConfiguration.class)
public class TestConfiguration {

    @Bean
    ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}
