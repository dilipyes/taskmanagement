package com.example.TaskManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagement.model.Tasks;
import com.example.TaskManagement.service.TasksService;

@RestController
@CrossOrigin
public class TasksController {

	@Autowired
	private TasksService taskService;

	@PostMapping("/task")
	public ResponseEntity<Tasks> addTask(@RequestBody Tasks tasks) {
		return new ResponseEntity<>(taskService.saveTask(tasks), HttpStatus.CREATED);

	}

	@GetMapping("/task")
	public ResponseEntity<List<Tasks>> getTask(@RequestParam(required = false) Long taskId,
			@RequestParam(required = false) Long userId) {
		return new ResponseEntity<>(taskService.getTask(taskId, userId), HttpStatus.OK);

	}

	@PutMapping("/task")
	public ResponseEntity<Tasks> updateTask(@RequestBody Tasks tasks) {
		return new ResponseEntity<>(taskService.updateTask(tasks), HttpStatus.OK);
	}

}
