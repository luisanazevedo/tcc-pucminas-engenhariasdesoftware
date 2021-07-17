package com.example.tcc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tcc.entities.Project;


public interface ProjectRepository extends JpaRepository<Project, Long>{
	

	Optional<Project> findByName(String name);
}
