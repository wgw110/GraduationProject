package com.graduation.message301;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import com.graduation.draw303.DrawMain;

public class HandleMessage implements Runnable {
	private Socket socket;
	private ObjectInputStream objectInputStream;

	public HandleMessage(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// 获得客户端的IP地址
		InetAddress address = socket.getInetAddress();
		String ip = address.getHostAddress();
		System.out.println(ip);

		// 获取得到的客户端的信息
		try {
			objectInputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			try {
				while (true) {
					Message message = (Message) objectInputStream.readObject();
					DrawMain drawMain = new DrawMain(message);
					drawMain.Draw();
					CPUMessage cpuMessage = message.getCpuMessage();
					MemoryMessage memoryMessage = message.getMemoryMessage();
					OSMessage osMessage = message.getOsMessage();
					List<InterMessage> list = message.getList();
					List<FileMessage> listFile=message.getFileList();
					//需要将客户端的信息写入到数据库之中，写的时候把客户端的IP地址传过去
					System.out.println("cpu message:");
					System.out.println(cpuMessage);
					System.out.println("memoryMessage:");
					System.out.println(memoryMessage);
					System.out.println("osMessage:");
					System.out.println(osMessage);
					System.out.println("InetAddress message");
					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i));
					}
					System.out.println("file message");
					for(int j=0;j<listFile.size();j++){
						System.out.println(listFile.get(j));
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
