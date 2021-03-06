package com.miage.spring.service.implement;

import java.util.List;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;

import com.miage.spring.exception.ProjectNotFoundException;
import com.miage.spring.model.Project;
import com.miage.spring.model.Topic;
import com.miage.spring.model.User;
import com.miage.spring.repository.ProjectRepository;
import com.miage.spring.repository.TopicRepository;
import com.miage.spring.repository.UserRepository;
import com.miage.spring.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService {
	
	private TopicRepository topicRepository ;
	private ProjectRepository projectRepository ;
	private UserRepository userRepository ;
	@Override
	public Topic save(Topic topic) {
		return topicRepository.save(topic);
	}

	@Override
	public Topic getOne(Long id) {
		return topicRepository.getOne(id);
	}

	@Override
	@PostFilter("@permissionService.canReadTopic(filterObject)")
	public List<Topic> getAllByProject(Project project) {
		return topicRepository.getAllByProject(project);
	}

	@Override
	public int countCreatedByUser(User user) {
		return topicRepository.countAllByCreatedBy(user);
	}

	@Override
	public boolean isCreator(Long userId, Topic topic) {
		return topic.getCreatedBy().getId().equals(userId);
	}

	@Override
	public boolean isFollowing(Long userId, Topic topic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadTestCreation(int maxCreate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Topic save(Topic topic, Long projectId) throws ProjectNotFoundException {
		Project project = projectRepository.getOne(projectId);
		if (project == null) {
			throw new ProjectNotFoundException("Can't find project with id: " +projectId);
		}
		topic.setProject(project);
		return topicRepository.save(topic);
	}

}
