package org.camunda.bpm.getstarted.loanapprovalspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.history.HistoricActivityInstance;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.repository.ProcessDefinitionQuery;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 */
@Controller
@RequestMapping("/app")
@Slf4j
public class TestController {
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ManagementService managementService;

    @Autowired
    private IdentityService identityService;

    @GetMapping("/startProcessInstanceByKey")
    public void startProcessInstanceByKey(String key) {
        Map<String, Object> variables = new HashMap<String, Object>();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, variables);
    }

    @GetMapping("/getProcessList")
    public void getProcessList() {
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> list = processDefinitionQuery
                .orderByProcessDefinitionVersion()
                .desc()
                .list();
        for (ProcessDefinition processDefinition : list) {
            System.out.println("流程定义的ID:" + processDefinition.getId());
            System.out.println("流程定义的key:" + processDefinition.getKey());
            System.out.println("流程定义的name:" + processDefinition.getName());
            System.out.println("流程定义的版本号:"+ processDefinition.getVersion());
        }
    }

    @GetMapping("/getTaskList")
    public void getTaskList() {
        List<Task> list = taskService.createTaskQuery().list();
        for (Task task : list) {
            System.out.println("流程实例ID："+task.getProcessDefinitionId());
            System.out.println("任务ID:"+task.getId());
            System.out.println("任务负责人："+task.getAssignee());
            System.out.println("任务名称"+task.getName());
        }
    }

    @GetMapping("/getHistory")
    public void getHistory() {
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery().list();
        for (HistoricActivityInstance historicActivityInstance : list) {
            System.out.println(historicActivityInstance.getActivityId());
            System.out.println(historicActivityInstance.getActivityName());
            System.out.println(historicActivityInstance.getActivityType());
            System.out.println(historicActivityInstance.getAssignee());
            System.out.println(historicActivityInstance.getProcessDefinitionId());
            System.out.println(historicActivityInstance.getProcessInstanceId());
            System.out.println("----------------------");
        }
    }

}