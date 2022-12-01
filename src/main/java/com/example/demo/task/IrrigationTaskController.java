package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/task")
public class IrrigationTaskController {
    private TaskService taskService;

    @Autowired
    public IrrigationTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<IrrigationTask> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public void configureTask(@RequestBody IrrigationTask task) {
        taskService.configureNewTask(task);
    }



}
