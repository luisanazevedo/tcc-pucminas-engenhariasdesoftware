package com.example.tcc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tcc.entities.Task;
import com.example.tcc.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public List<Task> findAll(){
		return repository.findAll();
	}
	
	public Task insert(Task obj) {
		return repository.save(obj);
	}
	
	public Task findName(String name) {
	    Optional<Task> obj = repository.findByName(name); 
	    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!", name));
	}
	
	
}
