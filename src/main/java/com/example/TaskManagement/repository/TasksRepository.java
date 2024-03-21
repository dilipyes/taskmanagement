package com.example.TaskManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManagement.model.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

	List<Tasks> findByUserId(Long userId);

}
