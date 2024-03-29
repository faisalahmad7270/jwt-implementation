package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsernameOrEmail(String username,String email);
}
