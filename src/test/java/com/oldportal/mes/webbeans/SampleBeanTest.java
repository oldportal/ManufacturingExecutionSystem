/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes.webbeans;

import com.oldportal.mes.TestConfiguration;
import com.oldportal.mes.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.context.WebApplicationContext;


/**
 * Just reference example.
 *
 * @author Dmitry Ognyannikov
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitConfig(TestConfiguration.class)
public class SampleBeanTest {
    //@Autowired
    //WebApplicationContext wac;

    @BeforeAll
    public void init() {

    }

    @Test
    public void testSecureService() {
//        String plainCreds = "guest:guest123";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Basic " + new String(Base64.
//                encode(plainCreds.getBytes())));
//        HttpEntity<String> request = new HttpEntity<>(headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080", HttpMethod.GET, request, String.class);
        //Assert.assertEquals("Hello World!", response.getBody());
    }
}
