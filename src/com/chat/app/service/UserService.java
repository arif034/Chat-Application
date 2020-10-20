package com.chat.app.service;

import com.chat.app.dto.UserDTO;
import com.chat.app.model.User;

public interface UserService {
	
	//public User insertUser(User user);
	public User fetchUser(Long id);
	public void saveNewUser(User user);
	public boolean validateUser(String username, String password);
	
}
