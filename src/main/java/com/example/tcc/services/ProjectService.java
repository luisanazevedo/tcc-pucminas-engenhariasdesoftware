package com.example.tcc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tcc.entities.Project;
import com.example.tcc.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository repository;
	
	public List<Project> findAll(){
		return repository.findAll();
	}
	
	public Project insert(Project obj) {
		return repository.save(obj);
	}
	
	public Project findName(String name) {
	    Optional<Project> obj = repository.findByName(name); 
	    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!", name));
	}
	
}
