package com.chat.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.dto.MessageDTO;
import com.chat.app.dto.UserDTO;
import com.chat.app.model.User;

@RestController("")
public class ChatClientController {
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/server", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String takeNewMessage( @RequestBody String json) throws Exception
	{
		ServerSocket serverSocket = new ServerSocket(8083);
		Socket s = serverSocket.accept();
		MessageDTO messageDTO = MessageDTO.fromJsonToMessageDTO(json);
		String messages = messageDTO.getMessage();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String message = br.readLine();		
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.println(messages);
		os.flush();
		String outString = " S : Message from Client  : " + message;
		return outString;
	}
	
	
	
	@RequestMapping(value = "/client", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String takeNewMessages( @RequestBody String json) throws Exception
	{
		String ipAddress = "localhost";
		int port = 8083;
		String message = "";
		String message2 = "";
		Socket s = new Socket(ipAddress, port);
		MessageDTO messageDTO = MessageDTO.fromJsonToMessageDTO(json);
		message = messageDTO.getMessage();
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.println(message);
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		message2 = br.readLine();
		String outString = " C : Message from Server  : " + message2;
		return outString;
		}
}
