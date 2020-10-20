package com.chat.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.app.dto.UserDTO;
import com.chat.app.model.User;
import com.chat.app.repository.UserRepository;
import com.chat.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	/*
	 * @Override public User insertUser(User user) {
	 * 
	 * return null; }
	 */

	@Override
	public User fetchUser(Long id)
	{
		User user = userRepository.fetchUser(id);
		return user;
	}
	
	@Override
	public void saveNewUser(User user)
	{
		User users = userRepository.saveAndFlush(user);
	}
	
	@Override
	public boolean validateUser(String username, String password)
	{
		if(userRepository.validateUser(username, password)!= null)
			return true;
		else
			return false;
	}
}
