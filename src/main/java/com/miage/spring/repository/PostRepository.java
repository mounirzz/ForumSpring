package com.miage.spring.repository;

import org.springframework.stereotype.Repository;

import com.miage.spring.model.Post;
import com.miage.spring.model.Topic;
import com.miage.spring.model.User;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> getAllByTopic(Topic topic);
	
	int countAllByCreatedBy(User user);
}
