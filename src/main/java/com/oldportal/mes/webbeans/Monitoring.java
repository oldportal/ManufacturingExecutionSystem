/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes.webbeans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Just reference example.
 * 
 * @author Dmitry Ognyannikov
 */
@ManagedBean(name = "monitoring")
@ViewScoped
@Transactional(value="transactionManager", readOnly = true, propagation=Propagation.REQUIRED)
public class Monitoring implements Serializable {
    @PostConstruct
    public void setup()  {
        
    }
}
