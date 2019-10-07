/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes.webbeans;

import com.oldportal.mes.TestConfiguration;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Just reference example.
 * 
 * In this test, the full Spring application context is started, but without the server (@AutoConfigureMockMvc -> MockMvc). 
 *
 * @author Dmitry Ognyannikov
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitConfig(TestConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleBeanTest {
    @Value("${local.server.port}")
    protected int port;
    
    @Autowired
    WebApplicationContext wac;
    
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public void init() {

    }
    
    @Test
    public void testEnvitonment() {
        assertNotNull(wac);
    }
    
    @Test
    public void testHomepage() throws Exception {
//        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello World!")));
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
