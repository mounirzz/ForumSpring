package com.miage.spring.service;

import java.util.List;

import com.miage.spring.model.Project;
import com.miage.spring.model.User;

public interface ProjectService {
	
	Project save(Project project);

	Project getOne(Long projectId);

	List<Project> getAllAllowed();

	int countCreatedByUser(User user);
}
