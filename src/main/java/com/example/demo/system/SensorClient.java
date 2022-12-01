package com.example.demo.system;

import com.example.demo.task.IrrigationTask;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.SocketOption;

@Service
public class SensorClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private String sensorURL = "http://localhost:8080/sensor";

    @Retry(name = "ratingService", fallbackMethod = "sensorFallback")
    public String callSensor(IrrigationTask task){
        System.out.println("Sensor called with " + task);
        return "success";
    }

    public String sensorFallback(Exception ex) {
        return "All retries to reach sensor have failed";
    }
}
