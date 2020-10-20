package com.chat.app.dto;

import org.apache.log4j.Logger;

import flexjson.JSONDeserializer;

public class MessageDTO {
	
	private static Logger logger = Logger.getLogger(UserDTO.class);
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static MessageDTO fromJsonToMessageDTO(String json){
		return new JSONDeserializer<MessageDTO>().use(null, MessageDTO.class).deserialize(json);
	}
	
}
