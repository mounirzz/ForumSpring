package com.miage.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miage.spring.model.Project;
import com.miage.spring.model.User;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	int countAllByCreatedBy(User user);
}
