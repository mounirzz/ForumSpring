package com.miage.spring.service.implement;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.miage.spring.model.User;
import com.miage.spring.service.UserService;
@Service
public class UserServiceImpl implements UserService {
		
	private 
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User eagerFindByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getAllProjectReaders(Long projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getAllProjectWriters(Long projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getAllTopicReaders(Long topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getAllTopicWriters(Long topicId) {
		// TODO Auto-generated method stub
		return null;
	}

}
