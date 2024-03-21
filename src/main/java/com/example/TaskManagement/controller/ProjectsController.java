package com.example.TaskManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagement.model.Projects;
import com.example.TaskManagement.service.ProjectsService;

@RestController
@CrossOrigin
public class ProjectsController {

	@Autowired
	private ProjectsService projectService;

	@PostMapping("/project")
	public ResponseEntity<Projects> addProject(@RequestBody Projects project) {
		return new ResponseEntity<>(projectService.save(project), HttpStatus.CREATED);
	}

	@GetMapping("/projects")
	public ResponseEntity<List<Projects>> getAllProjects() {
		return new ResponseEntity<>(projectService.fetchAll(), HttpStatus.OK);
	}

	@GetMapping("/project/{projectId}")
	public ResponseEntity<Projects> getProject(@PathVariable Long projectId) {
		return new ResponseEntity<>(projectService.getProject(projectId), HttpStatus.OK);
	}

	@PutMapping("/project/{projectId}")
	public ResponseEntity<Projects> updateProject(@PathVariable Long projectId, @RequestBody Projects project) {
		project.setProjectId(projectId);
		return new ResponseEntity<>(projectService.update(project), HttpStatus.OK);
	}

}
