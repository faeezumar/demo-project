package com.example.demo.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<IrrigationTask, Long> {
}
