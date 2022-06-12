package com.example.spring.training.user;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User saveUser = service.save(user);
		
		URI uri = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(saveUser.getId()).toUri();
			 
		return ResponseEntity.created(uri).build();
	}

	// Retrieve one User
	@GetMapping(path="/user/{id}")
	public User getUserById(@PathVariable int id) throws UserNotFoundException {
		User user = service.findById(id);
		if(user == null) {
			throw new UserNotFoundException("id: " + id);
		}
		return user;
	}
	
	//Delete user
	@DeleteMapping(path="user/{id}")
	public List<User> deleteUserById(@PathVariable int id){
		return service.delete(id);
	}
}
