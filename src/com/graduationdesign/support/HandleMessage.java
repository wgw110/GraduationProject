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
		// ��ÿͻ��˵�IP��ַ
		InetAddress address = socket.getInetAddress();
		String ip = address.getHostAddress();
        System.out.println("ip��"+ip);
		// ��ȡ�õ��Ŀͻ��˵���Ϣ
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
		// ����IP��ַ���������ݿ�User���в�ѯ����ص��û�����Ϣ
		User user = new UserDaoImpl().findByIPAddress(ip);
		CPUMessage cpuMessage = message.getCpuMessage();
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
		String date = dateFormat.format(now);
		cpuMessage.setDate(date);
		System.out.println(cpuMessage);
		new CPUDaoImpl().addCPUMessage(cpuMessage);
		// �����ڴ���Ϣ
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

		// ����Ӳ��ϵͳ��Ϣ
		// ����Ӳ��ϵͳ��Ϣ��ֻҪӲ��δ�ı�����Ӧ�ı��е����ݲ��ᷢ���ı�
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

		// ���������豸��Ϣ
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

		// �����ļ�ϵͳ��Ϣ
		// ���ν��յ����ļ�ϵͳ����Ϣ
		List<FileMessage> listFile = message.getFileList();
		// ���ݿ��д洢�����µ��ļ�ϵͳ��Ϣ
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
