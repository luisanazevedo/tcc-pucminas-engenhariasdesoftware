package com.example.tcc.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.tcc.entities.Project;
import com.example.tcc.services.ProjectService;

@RestController
@RequestMapping(value= "/projects")
public class ProjectResource {
	
	@Autowired
	private ProjectService service;
	
	@GetMapping
	public ResponseEntity<List<Project>> findAll(){
		List<Project> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
		
	@PostMapping
	public ResponseEntity<Project> insert(@RequestBody Project obj) {
		obj = service.insert(obj);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	

}
