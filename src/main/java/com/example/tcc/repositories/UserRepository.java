package com.example.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tcc.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	//Optional<User> findByName(String name);

}
