package com.example.TaskManagement.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManagement.helper.ApplicationHelper;
import com.example.TaskManagement.model.Projects;
import com.example.TaskManagement.repository.ProjectsRepository;

@Service
public class ProjectsService {

	@Autowired
	private ProjectsRepository projectRepo;

	public Projects save(Projects project) {
		project.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		project.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		return projectRepo.save(project);
	}

	public List<Projects> fetchAll() {
		return projectRepo.findAll();
	}

	public Projects update(Projects updatedProject) {
		updatedProject.setCreatedDate(null);
		updatedProject.setCreatedBy(null);
		Optional<Projects> proj = projectRepo.findById(updatedProject.getProjectId());
		if (!proj.isPresent())
			return null;
		Projects project = proj.get();
		ApplicationHelper.copyNonNullProperties(updatedProject, project);
		project.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		return projectRepo.save(project);
	}

	public Projects getProject(Long projectId) {
		Optional<Projects> project = projectRepo.findById(projectId);
		if (project.isPresent())
			return project.get();
		else
			return null;
	}

}
