package com.chat.app.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(8090);
		Socket s = ss.accept();
		
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msgIn = "", msgOut = "";
		
		while(!msgIn.equals("end"))
		{
			msgIn = din.readUTF();
			System.out.println(msgIn);
			msgOut = br.readLine();
			dout.writeUTF(msgOut);
			dout.flush();
		}
		s.close();
	}
}
