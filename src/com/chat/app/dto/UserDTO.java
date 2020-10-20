package com.chat.app.dto;

import org.apache.log4j.Logger;

import flexjson.JSONDeserializer;
public class UserDTO {
	private static Logger logger = Logger.getLogger(UserDTO.class);
	
	private Long id;
	private String firstname;
	private String lastname;
	private String password;
	private String username;
	private String email;
	private String region;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public static UserDTO fromJsonToUserDTO(String json){
		return new JSONDeserializer<UserDTO>().use(null, UserDTO.class).deserialize(json);
	}
}