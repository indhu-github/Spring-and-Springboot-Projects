package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findByUserName(String userName);
}
