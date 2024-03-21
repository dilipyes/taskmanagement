package com.example.TaskManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManagement.model.TasksType;
import com.example.TaskManagement.repository.TaskTypeRepository;

@Service
public class MasterDataService {
	
	@Autowired
	private TaskTypeRepository taskTypeRepo;
	

	public List<TasksType> fetchAllTaskTypes() {
		return taskTypeRepo.findAll();
	}
	

}
