package com.miage.spring.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miage.spring.model.Post;
import com.miage.spring.model.Topic;
import com.miage.spring.model.User;
import com.miage.spring.repository.PostRepository;
import com.miage.spring.repository.TopicRepository;
import com.miage.spring.service.PostService;
@Service
public class PostServiceImpl implements PostService {
	private  PostRepository postRepository;
	private  TopicRepository topicRepository;
	@Autowired
	public PostServiceImpl(PostRepository postRepository, TopicRepository topicRepository) {
		this.postRepository=postRepository;
		this.topicRepository=topicRepository ;
	}
	
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllByTopic(Topic topic) {
		return postRepository.getAllByTopic(topic);
	}

	@Override
	public int countCreateByUser(User user) {
		return postRepository.countAllByCreatedBy(user);
	}

	@Override
	public Post getOne(Long id) {
		return postRepository.getOne(id);
	}

	@Override
	public boolean exists(Long id) {
		return postRepository.exists(id);
	}

	@Override
	public boolean isCreator(Long userId, Post post) {
		return post.getCreatedBy().getId().equals(userId);
	}

	@Override
	public void loadTestCreation(int maxCreate) {
		// TODO Auto-generated method stub
	}

}
