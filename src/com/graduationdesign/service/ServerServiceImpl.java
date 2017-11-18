package com.graduationdesign.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.graduationdesign.support.HandleMessage;

public class ServerServiceImpl implements IServerService {

	@Override
	public void startServer() {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8080);
			boolean judge = true;
			while (judge) {
				Socket socket = serverSocket.accept();
				System.out.println("有客户端连接");
				new Thread(new HandleMessage(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
