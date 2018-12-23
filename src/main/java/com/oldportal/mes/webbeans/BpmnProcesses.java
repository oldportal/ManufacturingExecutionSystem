/*
 * Oldportal MES is available under the MIT License. See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Dmitry Ognyannikov
 */
package com.oldportal.mes.webbeans;

import java.util.List;
import java.util.Map;
import org.activiti.api.model.shared.model.VariableInstance;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.model.payloads.SetTaskVariablesPayload;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
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
    private ProcessRuntime processRuntime;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRuntime taskRuntime;

    @Autowired
    private RepositoryService repositoryService;
    
    @Autowired
    private HistoryService historyService;

    @Transactional
    public ProcessInstance startProcess(String definitionKey, String instanceName, Map<String, Object> variables) {
        //ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(definitionKey, variables);
        //ProcessInstance processInstance = runtimeService.createProcessInstanceBuilder().processDefinitionKey(definitionKey).name(instanceName).variables(variables).start();
        return processRuntime
                .start(ProcessPayloadBuilder
                        .start()
                        .withProcessDefinitionKey(definitionKey)
                        .withProcessInstanceName(instanceName)
                        .withVariables(variables)
                        .build());
    }

    @Transactional(readOnly = true)
    public List<Task> getAssignedTasks(String assignee) {
        return taskService.createTaskQuery()
                .taskAssignee(assignee)
                .list();
    }

    @Transactional(readOnly = true)
    public Page<org.activiti.api.task.model.Task> getAvailableTasksPage() {
        return taskRuntime.tasks(Pageable.of(0, 10));
    }

    /**
     * Create a Group Task (not assigned, all the members of the group can claim
     * it).
     *
     * @param taskName
     * @param taskDescription
     * @param priority
     * @param groupName
     */
    @Transactional
    public void createGroupTask(String taskName, String taskDescription, int priority, String candidateGroupName) {
        taskRuntime.create(TaskPayloadBuilder.create()
                .withName(taskName)
                .withDescription(taskDescription)
                .withCandidateGroup(candidateGroupName)
                .withPriority(priority)
                .build());
    }

    /**
     * Claim the task, after the claim, nobody else can see the task and the
     * user becomes the assignee.
     *
     * @param taskId
     */
    @Transactional
    public void claimTask(String taskId) {
        taskRuntime.claim(TaskPayloadBuilder.claim()
                .withTaskId(taskId)
                .build());
    }

    @Transactional
    public void completeTask(String taskId, Map<String, Object> variables) {
        taskRuntime.complete(TaskPayloadBuilder.complete()
                .withTaskId(taskId)
                .withVariables(variables)
                .build());
    }

    @Transactional(readOnly = true)
    public List<VariableInstance> getTaskVariables(String taskId) {
        return taskRuntime.variables(TaskPayloadBuilder.variables()
                .withTaskId(taskId)
                .build());
    }

    @Transactional
    public void setTaskVariables(String taskId, Map<String, Object> variables) {
        taskRuntime.setVariables(new SetTaskVariablesPayload(taskId, variables));
    }
    
    @Transactional
    public Task onTheFlyTask(String taskName) {
        Task task = taskService.newTask();
        task.setName(taskName);
        taskService.saveTask(task);
        return task;
    }
    
    @Transactional(readOnly = true)
    public void printHistory() {
        List<HistoricProcessInstance> processInstances = historyService.createHistoricProcessInstanceQuery().orderByProcessInstanceStartTime().asc().list();
        
        for (HistoricProcessInstance processInstance : processInstances) {            
            System.out.print("Process def Key: " + processInstance.getProcessDefinitionKey());
            System.out.print("Process def Name: " + processInstance.getProcessDefinitionName());
            
            System.out.print("Process Name: " + processInstance.getName());
            System.out.print("Process StartTime: " + processInstance.getStartTime());
            System.out.print("Process EndTime: " + processInstance.getEndTime());
            System.out.println();
        }
    }
    
    

}
