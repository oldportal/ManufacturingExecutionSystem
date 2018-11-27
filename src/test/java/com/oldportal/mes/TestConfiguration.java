/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring App configuration for unit tests.
 * 
 * @author Dmitry Ognyannikov
 */
@Configuration
@ImportResource("classpath:connections-test.xml")
public class TestConfiguration {
    
}
