package com.chat.app.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Client {
	
	public static void main(String[] args) throws IOException{
		
		String ipAddress = "localhost";
		int port = 8090;
		Socket s = new Socket(ipAddress, port);
		
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msgIn = "", msgOut = "";
		
		while(!msgIn.equals("end"))
		{
			msgOut = br.readLine();
			dout.writeUTF(msgOut);
			msgIn = din.readUTF();
			System.out.println(msgIn);
		}
	}
}