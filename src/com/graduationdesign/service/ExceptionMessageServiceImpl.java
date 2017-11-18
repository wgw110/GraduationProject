package com.graduationdesign.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import com.graduationdesign.dao.CPUDaoImpl;
import com.graduationdesign.dao.MemDaoImpl;
import com.graduationdesign.dao.UserDaoImpl;
import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.MemoryMessage;
import com.graduationdesign.support.SendMail;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExceptionMessageServiceImpl implements IExceptionMessageService {

	@Override
	public void storeCPUExceptionMessage() {
		String prefixList[] = { "wgw", "lsq" };
		for (int i = 0; i < prefixList.length; i++) {
			try {
				String prefix = prefixList[i];
				String source = "C:\\Users\\王国伟\\Desktop\\毕设\\excel\\" + prefix + "_cpuException.xls";
				// 打开文件
				WritableWorkbook book = Workbook.createWorkbook(new File(source));

				// 生成名为“第一页”的工作表，参数0表示这是第一页
				WritableSheet sheet = book.createSheet("sheet1", 0);
				Label init = null;
				init = new Label(0, 0, "date");
				sheet.addCell(init);
				init = new Label(1, 0, "ip");
				sheet.addCell(init);
				init = new Label(2, 0, "name");
				sheet.addCell(init);
				init = new Label(3, 0, "countPercent");
				sheet.addCell(init);
				init = new Label(4, 0, "userPercent");
				sheet.addCell(init);
				init = new Label(5, 0, "sysPercent");
				sheet.addCell(init);
				init = new Label(6, 0, "freePercent");
				sheet.addCell(init);
				int row = 1;

				CPUDaoImpl cpuDaoImpl = new CPUDaoImpl();
				List<CPUMessage> list = cpuDaoImpl.findException(80, prefix);
				System.out.println("list size:" + list.size());
				String name = new UserDaoImpl().findByPrefix(prefix).getName();
				String ip = new UserDaoImpl().findByPrefix(prefix).getIp();
				Label label = null;
				Number number = null;
				for (CPUMessage cpuMessage : list) {
					int column = 0;
					String date = cpuMessage.getDate();
					double countPercent = cpuMessage.getCountPercent();
					double userPercent = cpuMessage.getUserPercent();
					double sysPercent = cpuMessage.getSysPercent();
					double idlePercent = cpuMessage.getIdlePercent();
					label = new Label(column++, row, date);
					sheet.addCell(label);
					label = new Label(column++, row, name);
					sheet.addCell(label);
					label = new Label(column++, row, ip);
					sheet.addCell(label);
					number = new Number(column++, row, countPercent);
					sheet.addCell(number);
					number = new Number(column++, row, userPercent);
					sheet.addCell(number);
					number = new Number(column++, row, sysPercent);
					sheet.addCell(number);
					number = new Number(column++, row, idlePercent);
					sheet.addCell(number);
					row++;
				}
				// 写入数据并关闭文件
				book.write();
				book.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

	}

	@Override
	public void storeMemExceptionMessage() {
		String prefixList[] = { "wgw", "lsq" };
		for (int i = 0; i < prefixList.length; i++) {
			try {
				String prefix = prefixList[i];
				String source = "C:\\Users\\王国伟\\Desktop\\毕设\\excel\\" + prefix + "_memException.xls";
				// 打开文件
				WritableWorkbook book = Workbook.createWorkbook(new File(source));

				// 生成名为“第一页”的工作表，参数0表示这是第一页
				WritableSheet sheet = book.createSheet("sheet1", 0);
				Label init = null;
				init = new Label(0, 0, "date");
				sheet.addCell(init);
				init = new Label(1, 0, "ip");
				sheet.addCell(init);
				init = new Label(2, 0, "name");
				sheet.addCell(init);
				init = new Label(3, 0, "countMem");
				sheet.addCell(init);
				init = new Label(4, 0, "userPercent");
				sheet.addCell(init);
				init = new Label(5, 0, "freePercent");
				sheet.addCell(init);
				int row = 1;

				MemDaoImpl memDaoImpl = new MemDaoImpl();
				List<MemoryMessage> list = memDaoImpl.findException(80, prefix);
				System.out.println("list size:" + list.size());
				String name = new UserDaoImpl().findByPrefix(prefix).getName();
				String ip = new UserDaoImpl().findByPrefix(prefix).getIp();
				Label label = null;
				Number number = null;
				for (MemoryMessage memoryMessage : list) {
					int column = 0;
					String date = memoryMessage.getDate();
					double countMem = memoryMessage.getCountMem();
					double userPercent = memoryMessage.getUsedPercent();
					double freePercent = memoryMessage.getFreePercent();
					label = new Label(column++, row, date);
					sheet.addCell(label);
					label = new Label(column++, row, name);
					sheet.addCell(label);
					label = new Label(column++, row, ip);
					sheet.addCell(label);
					number = new Number(column++, row, countMem);
					sheet.addCell(number);
					number = new Number(column++, row, userPercent);
					sheet.addCell(number);
					number = new Number(column++, row, freePercent);
					sheet.addCell(number);
					row++;
				}
				// 写入数据并关闭文件
				book.write();
				book.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}
	}

	@Override
	public void sendExceptionByMail() throws MessagingException, IOException {
		String[] prefixList = { "wgw", "lsq" };
		for (int i = 0; i < prefixList.length; i++) {
			String prefix = prefixList[i];
			String name = new UserDaoImpl().findByPrefix(prefix).getName();
			String mail = new UserDaoImpl().findByPrefix(prefix).getMail();
			String source1 = "C:\\Users\\王国伟\\Desktop\\毕设\\excel\\" + prefix + "_memException.xls";
			String source2 = "C:\\Users\\王国伟\\Desktop\\毕设\\excel\\" + prefix + "_cpuException.xls";
			String[] source = { source1, source2 };
		//	System.out.println(mail);
			new SendMail().send(name, mail, source);
		}

	}
}
