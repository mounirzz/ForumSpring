package com.miage.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miage.spring.model.Project;
import com.miage.spring.model.Topic;
import com.miage.spring.model.User;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
	List<Topic> getAllByProject(Project project);

	@Query("select t form Topic t left join FETCH t.followers f where t.id = ?1")
	Topic eagerWithFollowers(Long id);

	int countAllByCreatedBy(User user);
}
