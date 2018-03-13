package com.miage.spring.service;

import com.miage.spring.model.Post;

public interface MailService {

	/**
	 * Send a notification to all followers of the topic of the post
	 */
	void sendNotifToAllFollowers(Post post);
}
