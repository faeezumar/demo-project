package com.example.demo.task;

import com.example.demo.system.SensorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class IrrigationTaskScheduler {
    private IrrigationTask currentTask;
    private SensorClient sensorClient;

    @Autowired
    public IrrigationTaskScheduler(SensorClient sensorClient) {
        this.sensorClient = sensorClient;
    }

    public void scheduleTask(IrrigationTask task) {
        this.currentTask = task;
        scheduleTask();
    }

    @Scheduled(cron = "@hourly")
    private void scheduleTask() {
        sensorClient.callSensor(currentTask);
    }
}
