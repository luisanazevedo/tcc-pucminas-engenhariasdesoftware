package com.example.tcc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.tcc.entities.Project;
import com.example.tcc.entities.Task;
import com.example.tcc.entities.User;
import com.example.tcc.repositories.ProjectRepository;
import com.example.tcc.repositories.TaskRepository;
import com.example.tcc.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
   
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Cláudio Henrique Lopes", "claudiohenriquelopes@dafitex.com.br", "uqXWKBFfgp");
		User u2 = new User(null, "Rafael Nathan Castro", "rrafaelnathancastro@netwis.com.br", "ctplKixwUX");
		User u3 = new User(null, "Fabiana Olivia Patrícia das Neves", "fabianaoliviapatriciadasneves-91@jetstar.com.br", "r4pucOZCDf");
		User u4 = new User(null, "Raimundo Lucas Heitor Brito", "rraimundolucasheitorbrito@stetnet.com.br", "yrhkaJe0rE");
		User u5 = new User(null, "Teresinha Beatriz Santos", "teresinhabeatrizsantos__teresinhabeatrizsantos@vieiradarocha.adv.br", "GTZa8gDEl6");
		User u6 = new User(null, "Regina", "reginasophiadamota@bitco.cc", "jpJ6FM5pLS");
		
		Project p1 = new Project(null, "Projeto 1");
		Project p2 = new Project(null, "Projeto 2");
		Project p3 = new Project(null, "Projeto 3");
		Project p4 = new Project(null, "Projeto 4");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6));
		projectRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
		p1.getUsers().add(u1);
		p1.getUsers().add(u6);
		p1.getUsers().add(u4);
		p1.getUsers().add(u5);
		p2.getUsers().add(u2);
		p2.getUsers().add(u6);
		p3.getUsers().add(u1);
		p3.getUsers().add(u2);
		p3.getUsers().add(u3);

		projectRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
		Task t1 = new Task(null, "Tarefa 1", u1, p1);
		Task t2 = new Task(null, "Tarefa 2", u2, p2);
		Task t3 = new Task(null, "Tarefa 3", u3, p3);
		Task t4 = new Task(null, "Tarefa 4", u4, p1);
		Task t5 = new Task(null, "Tarefa 5", u5, p1);
		Task t6 = new Task(null, "Tarefa 6", u6, p2);
		Task t7 = new Task(null, "Tarefa 7", u2, p3);
		Task t8 = new Task(null, "Tarefa 8", u4, p1);
		Task t9 = new Task(null, "Tarefa 9", u1, p1);
		Task t10 = new Task(null, "Tarefa 10", u1, p3);
		
		taskRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10));
	}
}
