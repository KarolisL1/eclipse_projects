package com.codingdojo.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookclub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public User findByEmail(String email);
}
