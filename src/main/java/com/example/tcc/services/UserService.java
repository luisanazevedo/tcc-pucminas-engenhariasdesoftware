package com.example.tcc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tcc.entities.User;
import com.example.tcc.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); 
	    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!", "teste"));
	}

	/*public User findName(String name) {
	    Optional<User> obj = repository.findByName(name); 
	    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!", name));
	}*/
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	
}
