package com.chat.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.dto.UserDTO;
import com.chat.app.model.User;
import com.chat.app.service.UserService;

@RestController("")
public class UserController
{
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/validate", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Boolean> validateUser(@RequestBody String json)
	{
		Boolean bool = new Boolean(true);
		UserDTO userDTO = UserDTO.fromJsonToUserDTO(json);
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		if(userService.validateUser(user.getUsername(), user.getPassword()))
			bool = true;
		else
			bool = false;
		return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/fetch", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public User fetchUserById(@RequestParam(value = "id", required = true) Long id)
	{
		User user = userService.fetchUser(id);
		return user;
	}
	
	
	@RequestMapping(value = "/save", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public void saveNewUser( @RequestBody String json)
	{
		try
		{
			UserDTO userDTO = UserDTO.fromJsonToUserDTO(json);
			User user = new User();
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setEmail(userDTO.getEmail());
			user.setRegion(userDTO.getRegion());
			userService.saveNewUser(user);
		}catch(Exception e)
		{
			logger.error("Error occured while regestering entry into database",e);
			throw e;
		}
	}
	
	@RequestMapping(value = "/createnewuser", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Boolean> createNewUser( @RequestBody String json)
	{
			Boolean bool = new Boolean(true);
			UserDTO userDTO = UserDTO.fromJsonToUserDTO(json);
			User user = new User();
			user.setFirstname(userDTO.getFirstname());
			user.setLastname(userDTO.getLastname());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setEmail(userDTO.getEmail());
			user.setRegion(userDTO.getRegion());
			userService.saveNewUser(user);
			bool = true;
			return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
	}
}