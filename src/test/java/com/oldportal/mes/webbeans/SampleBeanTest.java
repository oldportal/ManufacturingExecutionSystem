/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes.webbeans;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Just reference example.
 *
 * @author Dmitry Ognyannikov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@ContextConfiguration(value = {"classpath:connections-test.xml"})
//@ContextConfiguration(classes = WebAppConfiguration.class)
public class SampleBeanTest {
    //@Autowired
    //WebApplicationContext wac;

    @Before
    public void init() {

    }

    @Test
    public void test() {

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
