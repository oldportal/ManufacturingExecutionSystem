/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes.webbeans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * General operations with Activiti BPMN engine.
 * 
 * @author Dmitry Ognyannikov
 */
@Service
public class BpmnProcesses {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;
    
    @Autowired
    private IdentityService identityService;
    
    @Transactional
    public void initUsers() {
        Group group = identityService.newGroup("user");
        group.setName("users");
        group.setType("security-role");
        identityService.saveGroup(group);

        User admin = identityService.newUser("admin");
        admin.setPassword("admin");
        identityService.saveUser(admin);
    }
        
    @Transactional
    public void startProcess() {
        Map<String, Object> variables = new HashMap<>();
        //variables.put("person", person);
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
    }

    @Transactional
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }
}
