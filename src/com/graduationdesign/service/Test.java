package com.graduationdesign.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import com.graduationdesign.dao.CPUDaoImpl;
import com.graduationdesign.dao.FileDaoImpl;
import com.graduationdesign.dao.InetDaoImpl;
import com.graduationdesign.dao.MemDaoImpl;
import com.graduationdesign.dao.OSDaoImpl;
import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.MemoryMessage;

import edu.usfca.syndiag.Draw;

public class Test {
	public static void main(String[] args) throws MessagingException, IOException {
		// UserServiceImpl userServiceImpl = new UserServiceImpl();
		// String date = "2017/04/25 10:19";
		// String prefix = "wgw";
		// String string = date.replace(":", "#").replace("/", ".");
		// System.out.println(string);
		// MemoryMessage memoryMessage = userServiceImpl.findMem(date, prefix);
		// System.out.println(memoryMessage.getFreePercent());
		// System.out.println(memoryMessage.getUsedPercent());
		// // System.out.println(cpuMessage);
		// new DrawPictureImpl().drawMemBarChart(memoryMessage);
		// CPUDaoImpl cpuDaoImpl = new CPUDaoImpl();
		// List<CPUMessage> list = cpuDaoImpl.find(date, prefix);
		// System.out.println(list.size());
		// new DrawPictureImpl().drawCPULineChart(list);
		// new DrawPictureImpl().drawMemPieChart(memoryMessage);
		// List<MemoryMessage> list2 = new MemDaoImpl().find(date, prefix);
		// new DrawPictureImpl().drawMemLineChart(list2);
		new ExceptionMessageServiceImpl().sendExceptionByMail();
		
	}
}
