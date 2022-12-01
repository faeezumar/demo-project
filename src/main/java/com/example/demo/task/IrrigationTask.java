package com.example.demo.task;

import com.example.demo.plot.Plot;
import com.example.demo.system.TimeSlot;
import jakarta.persistence.*;

@Entity
public class IrrigationTask {
    enum JobStatus {
        SCHEDULED,
        ONGOING,
        FINISHED
    }

    @Id
    @GeneratedValue
    Long id;

    private JobStatus jobStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timeSlotId", referencedColumnName = "id")
    private TimeSlot period;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plotId", referencedColumnName = "id")
    private Plot plot;

    private Integer waterAmount;

    public IrrigationTask() {
    }

    public IrrigationTask(TimeSlot period, Plot plot, Integer waterAmount) {
        this.jobStatus = JobStatus.SCHEDULED;
        this.period = period;
        this.plot = plot;
        this.waterAmount = waterAmount;
    }

    public IrrigationTask(Long id, TimeSlot period, Plot plot, Integer waterAmount) {
        this.id = id;
        this.period = period;
        this.plot = plot;
        this.waterAmount = waterAmount;
    }

    public IrrigationTask(Long id, JobStatus jobStatus, TimeSlot period, Plot plot, Integer waterAmount) {
        this.id = id;
        this.jobStatus = jobStatus;
        this.period = period;
        this.plot = plot;
        this.waterAmount = waterAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public TimeSlot getPeriod() {
        return period;
    }

    public void setPeriod(TimeSlot period) {
        this.period = period;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public Integer getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(Integer waterAmount) {
        this.waterAmount = waterAmount;
    }

    @Override
    public String toString() {
        return "IrrigationTask{" +
                "id=" + id +
                ", jobStatus=" + jobStatus +
                ", period=" + period +
                ", plot=" + plot +
                ", waterAmount=" + waterAmount +
                '}';
    }
}
