package com.example.tcc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tcc.entities.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{
	
	Optional<Task> findByName(String name);

}
