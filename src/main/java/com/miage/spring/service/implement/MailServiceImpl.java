package com.miage.spring.service.implement;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;

import com.miage.spring.model.Post;
import com.miage.spring.model.Topic;
import com.miage.spring.model.User;
import com.miage.spring.repository.TopicRepository;
import com.miage.spring.service.MailService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private TopicRepository topicRepository ;
	@Autowired
	private JavaMailSender sender ;
	@Autowired
	private TemplateEngine templateEngine ;
	
	@Override
	@Transactional(readOnly = true)
	public void sendNotifToAllFollowers(Post post) {
		Topic topic = topicRepository.eagerWithFollowers(post.getTopic().getId());
		User author = post.getCreatedBy();
		Set<User> followers = topic.getFollowers();
		if (followers != null && !followers.isEmpty()) {
			followers.forEach(follower -> sendNotifEmail(follower, author, topic, post));
		}
	}
	/**
	 * Method that send an email to a user, about a new post in a topic
	 */
	
	/**
	 * 
	 * @param user
	 * @param author
	 * @param topic
	 * @param post
	 */
	private void sendNotifEmail(User user, User author,Topic topic,Post post) {
		//Don't send email to creator
		if (user.getEmail().equals(author.getEmail())) {
			return;
		}
		MimeMessagePreparator messagePreparator= mimeMessage ->{
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
		}
	}

}
