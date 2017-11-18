package com.graduationdesign.support;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.graduationdesign.dao.CPUDaoImpl;
import com.graduationdesign.dao.FileDaoImpl;
import com.graduationdesign.dao.InetDaoImpl;
import com.graduationdesign.dao.MemDaoImpl;
import com.graduationdesign.dao.OSDaoImpl;
import com.graduationdesign.dao.UserDaoImpl;
import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.FileMessage;
import com.graduationdesign.po.InterMessage;
import com.graduationdesign.po.MemoryMessage;
import com.graduationdesign.po.OSMessage;
import com.graduationdesign.po.User;

import javassist.expr.NewArray;

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
        System.out.println("ip："+ip);
		// 获取得到的客户端的信息
		try {
			objectInputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			try {
				boolean judge = true;
				while (judge) {
					Message message = (Message) objectInputStream.readObject();
					storeMessage(message, ip);

				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void storeMessage(Message message, String ip) {
		// 根据IP地址可以在数据库User表中查询到相关的用户的信息
		User user = new UserDaoImpl().findByIPAddress(ip);
		CPUMessage cpuMessage = message.getCpuMessage();
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
		String date = dateFormat.format(now);
		cpuMessage.setDate(date);
		System.out.println(cpuMessage);
		new CPUDaoImpl().addCPUMessage(cpuMessage);
		// 处理内存信息
		MemoryMessage memoryMessage = message.getMemoryMessage();
		MemoryMessage memoryMessageLast = new MemDaoImpl().findNew(user.getPrefix());
		if (memoryMessageLast == null) {
			memoryMessage.setDate(date);
			new MemDaoImpl().addMemMessage(memoryMessage);
		} else {
			if (Math.abs(memoryMessage.getFreePercent() - memoryMessageLast.getFreePercent()) >= 1
					|| Math.abs(memoryMessage.getUsedPercent() - memoryMessageLast.getUsedPercent()) >= 1
					|| Math.abs(memoryMessage.getSwapUsed() - memoryMessageLast.getSwapUsed()) >= 100
					|| Math.abs(memoryMessage.getSwapFree() - memoryMessageLast.getSwapFree()) >= 100) {
				memoryMessage.setDate(date);
				new MemDaoImpl().addMemMessage(memoryMessage);
			}
		}

		// 处理硬件系统信息
		// 对于硬件系统信息，只要硬件未改变则相应的表中的数据不会发生改变
		OSMessage osMessage = message.getOsMessage();
		osMessage.setDate(date);
		OSMessage osMessageLast = new OSDaoImpl().findNew(user.getPrefix());
		if (osMessageLast == null) {
			new OSDaoImpl().addOSMessage(osMessage);
		} else if (!osMessageLast.getName().equals(osMessage.getName())
				|| !osMessage.getArch().equals(osMessageLast.getArch())
				|| !osMessage.getCpuEndian().equals(osMessageLast.getCpuEndian())
				|| !osMessage.getDataModel().equals(osMessageLast.getDataModel())
				|| !osMessage.getDescription().equals(osMessageLast.getDescription())
				|| !osMessage.getVendor().equals(osMessageLast.getVendor())
				|| !osMessage.getVersion().equals(osMessageLast.getVersion())) {
			new OSDaoImpl().addOSMessage(osMessage);
		}

		// 处理网络设备信息
		List<InterMessage> list = message.getList();
		List<InterMessage> lastList = new InetDaoImpl().findNew(user.getPrefix());
		if (lastList == null || lastList.size() == 0) {
			for (InterMessage interMessage : list) {
				interMessage.setDate(date);
				new InetDaoImpl().addInetMessage(interMessage);
			}
		} else {
			boolean isChanged = false;
			int size = lastList.size();
			for (int i = 0; i < size; i++) {
				InterMessage interMessage = list.get(i);
				InterMessage interMessageLast = lastList.get(i);
				if (!interMessage.getName().equals(interMessageLast.getName())
						|| Math.abs(interMessage.getReceiveBytes() - interMessageLast.getReceiveBytes()) >= 10000
						|| Math.abs(interMessage.getReceiveDroped() - interMessageLast.getReceiveDroped()) >= 10
						|| Math.abs(interMessage.getReceiveErrors() - interMessageLast.getReceiveErrors()) >= 10
						|| Math.abs(interMessage.getReceivePackets() - interMessageLast.getReceivePackets()) >= 100
						|| Math.abs(interMessage.getSendBytes() - interMessageLast.getSendBytes()) >= 10000
						|| Math.abs(interMessage.getSendDroped() - interMessageLast.getSendDroped()) >= 10
						|| Math.abs(interMessage.getSendErrors() - interMessageLast.getSendErrors()) >= 10
						|| Math.abs(interMessage.getSendPackets() - interMessageLast.getSendPackets()) >= 100) {
					isChanged = true;
					break;
				}

			}
			if (isChanged == true) {
				for (InterMessage interMessage : list) {
					interMessage.setDate(date);
					new InetDaoImpl().addInetMessage(interMessage);
				}
			}

		}

		// 处理文件系统信息
		// 本次接收到的文件系统的信息
		List<FileMessage> listFile = message.getFileList();
		// 数据库中存储的最新的文件系统信息
		List<FileMessage> lastFile = new FileDaoImpl().findNew(user.getPrefix());
		if (lastFile == null || lastFile.size() == 0) {
			for (FileMessage fileMessage : listFile) {
				fileMessage.setDate(date);
				new FileDaoImpl().addFileMessage(fileMessage);
			}
		} else {
			boolean isChange = false;
			int size;
			size = lastFile.size();
			for (int i = 0; i < size; i++) {
				FileMessage fileMessageNew = listFile.get(i);
				FileMessage fileMessagelast = lastFile.get(i);
				if (!fileMessagelast.getFileDir().equals(fileMessageNew.getFileDir())
						|| Math.abs(fileMessagelast.getFileFree() - fileMessageNew.getFileFree()) >= 10
						|| !fileMessagelast.getFileName().equals(fileMessageNew.getFileName())
						|| fileMessagelast.getFilePercent() != fileMessageNew.getFilePercent()
						|| Math.abs(fileMessagelast.getFileTotal() - fileMessageNew.getFileTotal()) >= 10
						|| !fileMessagelast.getFileType().equals(fileMessageNew.getFileType())
						|| !fileMessagelast.getFileTypeName().equals(fileMessageNew.getFileTypeName())
						|| Math.abs(fileMessagelast.getFileUsed() - fileMessageNew.getFileUsed()) >= 10) {
					isChange = true;
					break;
				}
			}
			if (isChange == true) {
				for (FileMessage fileMessage : listFile) {
					fileMessage.setDate(date);
					new FileDaoImpl().addFileMessage(fileMessage);
				}
			}
		}

	}

}
