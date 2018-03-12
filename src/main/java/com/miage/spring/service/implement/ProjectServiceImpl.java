package com.miage.spring.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;

import com.miage.spring.model.Project;
import com.miage.spring.model.User;
import com.miage.spring.repository.ProjectRepository;
import com.miage.spring.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepository;

	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project getOne(Long projectId) {
		return projectRepository.getOne(projectId);
	}

	@Override
	@PostFilter("@permissionService.canReadProject(filterObject)")
	public List<Project> getAllAllowed() {
		return projectRepository.findAll();
	}

	@Override
	public int countCreatedByUser(User user) {
		return projectRepository.countAllByCreatedBy(user);
	}

}
