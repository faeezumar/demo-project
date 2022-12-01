package com.example.demo.plot;

import com.example.demo.task.IrrigationTask;
import jakarta.persistence.*;

@Entity
public class Plot {
    @Id
    @SequenceGenerator(
            name = "plot_sequence",
            sequenceName = "plot_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plot_sequence"
    )
    private Long id;
    private int width;
    private int height;
    private double  moisture;

    private String name;

    private String description;

    @OneToOne
    private IrrigationTask irrigationTask;

    public Plot() {
    }

    //Constructor without id
    public Plot(int width, int height, double moisture, String name, String description) {
        this.width = width;
        this.height = height;
        this.moisture = moisture;
        this.name = name;
        this.description = description;
    }

    //Constructor with id
    public Plot(Long id, int width, int height, double moisture, String name, String description) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.moisture = moisture;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Plot{" +
                "id=" + id +
                ", width=" + width +
                ", height=" + height +
                ", moisture=" + moisture +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
