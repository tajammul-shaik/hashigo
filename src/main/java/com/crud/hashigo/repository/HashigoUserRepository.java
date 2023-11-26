package com.crud.hashigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.hashigo.models.User;

@Repository
public interface HashigoUserRepository extends JpaRepository<User, Long> {
	
}
