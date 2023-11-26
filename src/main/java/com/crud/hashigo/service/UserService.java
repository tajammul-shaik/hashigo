package com.crud.hashigo.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.crud.hashigo.exceptions.ResourceNotFoundException;
import com.crud.hashigo.models.User;

public interface UserService {

	public List<User> getAllUser();

	public ResponseEntity<User> getUserById(Long userId) throws ResourceNotFoundException;

	public User createUser(User user);

	public ResponseEntity<User> updateUser(Long userId, User userDetails) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteUser(Long userId) throws ResourceNotFoundException;
}
