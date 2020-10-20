package com.chat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chat.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	@Query(nativeQuery = true, value = "SELECT * from user where id = ?1")
	public User fetchUser(Long id);
	
	@Query(nativeQuery = true, value = "SELECT * from user where username = ?1 and password = ?2")
	public User validateUser(String username, String password);
}
