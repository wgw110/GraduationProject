package com.graduation.message301;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket=new ServerSocket(8080);
			boolean judge=true;
			 while(judge){
				 Socket socket=serverSocket.accept();
				 System.out.println("有客户端连接");
				 new Thread(new HandleMessage(socket)).start();				 
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
