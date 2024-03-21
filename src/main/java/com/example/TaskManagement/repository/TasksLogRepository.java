package com.example.TaskManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManagement.model.TasksLog;

@Repository
public interface TasksLogRepository extends JpaRepository<TasksLog, Long> {

}
