package com.example.TaskManagement.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManagement.helper.ApplicationHelper;
import com.example.TaskManagement.model.Tasks;
import com.example.TaskManagement.model.TasksLog;
import com.example.TaskManagement.repository.TasksLogRepository;
import com.example.TaskManagement.repository.TasksRepository;

@Service
public class TasksService {

	@Autowired
	private TasksRepository tasksRepo;

	@Autowired
	private TasksLogRepository taskLogRepo;

	public Tasks saveTask(Tasks tasks) {
		tasks.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		tasks.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		TasksLog taskLog = new TasksLog();
		BeanUtils.copyProperties(tasks, taskLog);
		taskLogRepo.save(taskLog);
		return tasksRepo.save(tasks);
	}

	public List<Tasks> getTask(Long taskId, Long userId) {
		if (taskId != null) {
			Optional<Tasks> task = tasksRepo.findById(taskId);
			return task.isPresent() ? Arrays.asList(task.get()) : null;
		} else if (userId != null)
			return tasksRepo.findByUserId(userId);
		else
			return Collections.emptyList();
	}

	public Tasks updateTask(Tasks updatedTasks) {
		Optional<Tasks> task = tasksRepo.findById(updatedTasks.getTaskId());
		if (task.isEmpty())
			return null;
		Tasks tasks = task.get();
		tasks.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		ApplicationHelper.copyNonNullProperties(updatedTasks, tasks);
		TasksLog taskLog = new TasksLog();
		BeanUtils.copyProperties(task, taskLog);
		taskLogRepo.save(taskLog);
		return tasksRepo.save(updatedTasks);
	}

}
