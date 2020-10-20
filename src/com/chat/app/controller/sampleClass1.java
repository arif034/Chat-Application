package com.chat.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.chat.app.dto.MessageDTO;

public class sampleClass1 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
	String ipAddress = "localhost";
	int port = 8083;
	Socket s = new Socket(ipAddress, port);
	
	String message = "Hi from Server !";
	OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
	PrintWriter out = new PrintWriter(os);
	out.println(message);
	os.flush();

	BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	String message2 = br.readLine();
	System.out.println("Data from server  " + message2 + "lol");
	}
}
