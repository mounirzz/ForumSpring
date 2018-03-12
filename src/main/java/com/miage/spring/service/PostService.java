package com.miage.spring.service;

import java.util.List;

import com.miage.spring.model.Post;
import com.miage.spring.model.Topic;
import com.miage.spring.model.User;

public interface PostService {

	/**
	 * Save a post and Set it's topic
	 */
	// Post save(Post post, Long topicId) throws TopicNotFoundException;

	/**
	 * Save a post without setting it's topic this method is used when editing a
	 * post
	 */
	Post save(Post post);

	List<Post> getAllByTopic(Topic topic);

	int countCreateByUser(User user);

	Post getOne(Long id);

	boolean exists(Long id);

	boolean isCreator(Long userId, Post post);

	void loadTestCreation(int maxCreate);
}
