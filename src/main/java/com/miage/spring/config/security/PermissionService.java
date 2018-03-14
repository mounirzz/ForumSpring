package com.miage.spring.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.miage.spring.config.MyPrincipal;
import com.miage.spring.model.Permission;
import com.miage.spring.model.Project;
import com.miage.spring.model.Topic;
import com.miage.spring.service.ProjectService;
import com.miage.spring.service.TopicService;

public class PermissionService {
	@Autowired
	private TopicService topicService;
	@Autowired
	private ProjectService projectService;
	
	public boolean canReadTopic(Topic topic) {
		return topic.hasPermission(getPrincipalId(), Permission.READ);
	}
	public boolean canWriteTopic(Topic topic) {
		return topic.hasPermission(getPrincipalId(), Permission.WRITE);
	}
	public boolean canReadTopic(Long topicId) {
		Topic topic = topicService.getOne(topicId);
		return topic.hasPermission(getPrincipalId(), Permission.READ);
	}
	public boolean canWriteTopic(Long topicId) {
		Topic topic = topicService.getOne(topicId);
		return topic.hasPermission(getPrincipalId(), Permission.WRITE);
	}
	public boolean canReadProject(Project project) {
		return project.hasPermission(getPrincipalId(), Permission.READ);
	}
	public boolean canWriteProject(Project project) {
		return project.hasPermission(getPrincipalId(), Permission.WRITE);
	}
	public boolean canReadProject(Long projectId) {
		Project project = projectService.getOne(projectId);
		return project.hasPermission(getPrincipalId(), Permission.READ);
	}
	public boolean canWriteProject(Long projectId) {
		Project project = projectService.getOne(projectId);
		return project.hasPermission(getPrincipalId(), Permission.WRITE);
	}
	private Long getPrincipalId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication !=null && !(authentication instanceof AnonymousAuthenticationToken)) {
			return ((MyPrincipal) authentication.getPrincipal()).getId();
		}
		return null;
	}
}
