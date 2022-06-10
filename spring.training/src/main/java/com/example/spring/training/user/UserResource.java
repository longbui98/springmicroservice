package com.example.spring.training.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService service;

	// Retrive all Users
	@GetMapping(path = "/users")
	public List<User> getAllUser() {
		return service.findAll();
	}

	// Create User
	@PostMapping(path = "/users")
	public User createUser() {
		User user = new User(4, "Python", new Date());
		return service.save(user);
	}

	// Retrieve one User
	@GetMapping(path="/user/{id}")
	public User getUserById(@PathVariable int id) {
		return service.findById(id);
	}
	
	//Delete user
	@DeleteMapping(path="users/{id}")
	public List<User> deleteUserById(@PathVariable int id){
		return service.delete(id);
	}
}
