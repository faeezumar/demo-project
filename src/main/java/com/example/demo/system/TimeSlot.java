package com.example.demo.system;

import com.example.demo.task.IrrigationTask;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToOne
    private IrrigationTask IrrigationTask;

    public TimeSlot() {
    }

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public IrrigationTask getIrrigationTask() {
        return IrrigationTask;
    }

    public void setIrrigationTask(IrrigationTask irrigationTask) {
        IrrigationTask = irrigationTask;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", IrrigationTask=" + IrrigationTask +
                '}';
    }
}
