package com.example.TaskManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TaskManagement.model.TasksType;

@Repository
public interface TaskTypeRepository extends JpaRepository<TasksType, Long> {

}
