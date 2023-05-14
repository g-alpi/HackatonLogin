package com.hackatonLogin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackatonLogin.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername (String username);
}
