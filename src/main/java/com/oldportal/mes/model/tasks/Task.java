/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes.model.tasks;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * The base class for MES - specific BPMN tasks. 
 * 
 * @author Dmitry Ognyannikov
 */
@Entity
@Data
public class Task implements Serializable {
    @Id
    private long id;
}
