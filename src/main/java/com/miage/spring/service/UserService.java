package com.miage.spring.service;

import java.util.List;
import java.util.Set;

import com.miage.spring.config.security.UserDetailsImpl;
import com.miage.spring.model.User;

public interface UserService {

	User save(User user);

	User getOne(Long id);

	List<User> getAll();

	UserDetailsImpl getUserDetails(User user);
	User eagerFindByEmail(String email);

	Set<User> getAllProjectReaders(Long projectId);

	Set<User> getAllProjectWriters(Long projectId);

	Set<User> getAllTopicReaders(Long topicId);

	Set<User> getAllTopicWriters(Long topicId);
}
