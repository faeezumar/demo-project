package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private IrrigationTaskScheduler irrigationTaskScheduler;

    @Autowired
    public TaskService(
            TaskRepository taskRepository,
            IrrigationTaskScheduler irrigationTaskScheduler) {
        this.taskRepository = taskRepository;
        this.irrigationTaskScheduler = irrigationTaskScheduler;
    }

    public List<IrrigationTask> getTasks() {
        return taskRepository.findAll();
    }

    public void configureNewTask(IrrigationTask task) {
        irrigationTaskScheduler.scheduleTask(task);
    }
}
