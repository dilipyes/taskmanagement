package com.example.TaskManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagement.model.TasksType;
import com.example.TaskManagement.service.MasterDataService;

@RestController
@CrossOrigin
public class MasterDataController {

	@Autowired
	private MasterDataService masterDataService;

	@GetMapping("/tasktypes")
	public ResponseEntity<List<TasksType>> fetchAllTaskTypes() {
		return new ResponseEntity<>(masterDataService.fetchAllTaskTypes(), HttpStatus.OK);
	}

}
