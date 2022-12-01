package com.example.demo.task;

import com.example.demo.plot.Plot;
import com.example.demo.system.TimeSlot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner preConfigureTasks(IrrigationTaskController c) {
        return args -> {
            IrrigationTask t1 = new IrrigationTask(
                    1L,
                    new TimeSlot(
                            LocalDateTime.of(2022, 2, 13, 15, 56),
                            LocalDateTime.of(2022, 2, 13, 15, 56)),
                    new Plot(2000, 2000, 0, "New Plot", "New plot of land"),
                    100
            );

            c.configureTask(t1);
        };
    }
}
