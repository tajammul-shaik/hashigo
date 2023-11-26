package com.crud.hashigo.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.hashigo.exceptions.ResourceNotFoundException;
import com.crud.hashigo.models.User;
import com.crud.hashigo.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class UsersController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userServiceImpl.getAllUser();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		return userServiceImpl.getUserById(userId);
	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userServiceImpl.createUser(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		return userServiceImpl.updateUser(userId, userDetails);
	}

	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		return userServiceImpl.deleteUser(userId);
	}
}
