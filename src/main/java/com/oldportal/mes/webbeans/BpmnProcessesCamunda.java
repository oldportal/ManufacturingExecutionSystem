/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes.webbeans;

import java.util.List;
import org.camunda.bpm.engine.ExternalTaskService;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.externaltask.LockedExternalTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * General operations with Camunda BPM engine.
 * 
 * @author Dmitry Ognyannikov
 */
@Service
public class BpmnProcessesCamunda {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private ExternalTaskService externalTaskService;

    @Autowired
    private RepositoryService repositoryService;
    
    @Autowired
    private HistoryService historyService;
    
    
    public void fetchAndExceuteTask(String externalWorkerId) {
        try {
            // 10 tasks
            List<LockedExternalTask> tasks = externalTaskService.fetchAndLock(10, externalWorkerId)
            .topic("AddressValidation", 60L * 1000L).variables("address")
            .execute();
            for (LockedExternalTask task : tasks) {
                try {
                    String topic = task.getTopicName();
                    //MyAddressClass address = (MyAddressClass) task.getVariables().get("address");


                    // if the work is successful, mark the task as completed
                    boolean success = true;
                    if(success) {
                        externalTaskService.complete(task.getId(), externalWorkerId);
                    }
                    else {
                      // if the work was not successful, mark it as failed
                      externalTaskService.handleFailure(
                        task.getId(),
                        externalWorkerId,
                        "Address could not be validated: Address database not reachable",
                        1, 10L * 60L * 1000L);
                    }
                } catch(Exception e) {
                    //... handle exception
                }
            }
        } finally {
            externalTaskService.unlock(externalWorkerId);
        }
    }
    
}
