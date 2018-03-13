package com.miage.spring.service.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.miage.spring.model.Role;
import com.miage.spring.model.User;
import com.miage.spring.repository.RoleRepository;
import com.miage.spring.repository.UserRepository;
import com.miage.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			@Lazy BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User save(User user) {
		// user.
		return null;
	}

	@Override
	public User getOne(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User eagerFindByEmail(String email) {
		return userRepository.eagerFindByEmail(email);
	}

	@Override
	public Set<User> getAllProjectReaders(Long projectId) {
		return userRepository.getAllProjectReaders(projectId);
	}

	@Override
	public Set<User> getAllProjectWriters(Long projectId) {
		return userRepository.getAllProjectWriters(projectId);
	}

	@Override
	public Set<User> getAllTopicReaders(Long topicId) {
		return userRepository.getAllTopicReaders(topicId);
	}

	@Override
	public Set<User> getAllTopicWriters(Long topicId) {
		return userRepository.getAllTopicWriters(topicId);
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>(roles.size());
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

}
