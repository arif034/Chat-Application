package com.chat.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import com.chat.app.dto.MessageDTO;

public class SampleClass2 {

	public static void main(String[] args) throws IOException {
		
	System.out.println("Server is started");
	ServerSocket serverSocket = new ServerSocket(8083);
	System.out.println("Server is waitting for client request");
	Socket s = serverSocket.accept();
	BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	String message = br.readLine();
	System.out.println("S: Client Data ");
	String messages = "messaage2";
	
	OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
	PrintWriter out = new PrintWriter(os);
	out.println(messages);
	os.flush();
	System.out.println("S : data sent from Server to Client ");
	String ssa = "String here";
	ArrayList<String> al = (ArrayList<String>) Arrays.asList("Hi ","My name is"," Arif");
	}
}
