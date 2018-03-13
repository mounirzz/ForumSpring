package com.miage.spring.service.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;

import com.miage.spring.model.Post;
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
		// TODO Auto-generated method stub
		
	}

}
