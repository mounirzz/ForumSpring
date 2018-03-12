package com.miage.spring.service;

import java.util.List;

import com.miage.spring.model.Project;
import com.miage.spring.model.Topic;
import com.miage.spring.model.User;

public interface TopicService {
	Topic save(Topic topic);

	//Topic save(Topic topic, Long projectId) throws ProjectNotFoundException;

	Topic getOne(Long id);

	List<Topic> getAllByProject(Project project);

	int countCreatedByUser(User user);

	boolean isCreator(Long userId, Topic topic);

	boolean isFollowing(Long userId, Topic topic);

	void loadTestCreation(int maxCreate);
}
