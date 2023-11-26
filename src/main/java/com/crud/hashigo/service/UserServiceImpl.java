package com.crud.hashigo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.hashigo.exceptions.ResourceNotFoundException;
import com.crud.hashigo.models.User;
import com.crud.hashigo.repository.HashigoUserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private HashigoUserRepository hashigoUserRepository;

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return hashigoUserRepository.findAll();
	}

	@Override
	public ResponseEntity<User> getUserById(Long userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user = hashigoUserRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return hashigoUserRepository.save(user);
	}

	@Override
	public ResponseEntity<User> updateUser(Long userId, User userDetails) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user = hashigoUserRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setEmailId(userDetails.getEmailId());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		final User updateUser = hashigoUserRepository.save(user);
		return ResponseEntity.ok(updateUser);
	}

	@Override
	public Map<String, Boolean> deleteUser(Long userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user = hashigoUserRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		hashigoUserRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
