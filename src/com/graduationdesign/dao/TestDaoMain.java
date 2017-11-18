package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.MemoryMessage;
import com.graduationdesign.po.OSMessage;
import com.graduationdesign.po.User;

public class TestDaoMain {

	public static void main(String[] args) {
		// 测试添加用户，查询用户，更改用户信息，删除用户信息功能
		// User user = new User();
		// user.setIp("172.18.3.3");
		// user.setMail("1023076445@qq.com");
		// user.setName("路淑清");
		// user.setPassword("2013217155");
		// UserDaoImpl userDaoImpl = new UserDaoImpl();
		// userDaoImpl.adduser(user);
		// userDaoImpl=new UserDaoImpl();
		// String ip = "172.18.3.3";
		// User user = userDaoImpl.findByIPAddress(ip);
		// System.out.println(user);
		// String name = "路淑清";
		// User user2 = userDaoImpl.findByNmae(name);
		// System.out.println(user2);
		// userDaoImpl = new UserDaoImpl();
		// userDaoImpl.updateUser("路淑清");
		// userDaoImpl.deleteUser("172.18.3.3");

		// 测试向不同用户对应的cpu信息表中添加数据，查询数据以及删除数据，各个用户对应的表的名称用前缀来区分
		// 添加类时根据创建的实体类的对象的不同，经过配置文件解析会自动将数据添加到相应的类中.
		// CPUMessage cpuMessage = new User1CPU();
		//
		// Date now = new Date();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd
		// HH:mm");
		// String date = dateFormat.format(now);
		// cpuMessage.setId(3);
		// cpuMessage.setDate(date);
		// cpuMessage.setIdlePercent(100);
		// cpuMessage.setCountMhz(100);
		// cpuMessage.setUserPercent(100);
		// cpuMessage.setSysPercent(100);
		// CPUDaoImpl cpuDaoImpl = new CPUDaoImpl();
		// cpuDaoImpl.addCPUMessage(cpuMessage);
		// 查找数据时，主要是根据用户表user中用户对应的ip地址以及前缀来构建sql语句，之后sql语句经配置文件解析会自动在相应的表之中
		// 完成查询数据的操作。而删除数据的操作与此类似
		// String prefix = "wgw";
		// String date2 = "2017/04/19 22";
		// List<CPUMessage> list = cpuDaoImpl.find(date2, prefix);
		// System.out.println("list size():" + list.size());
		//
		// System.out.println(list.get(0));
		// System.out.println(list.get(1));
		// List<CPUMessage> list2 = cpuDaoImpl.findException(80, "wgw");
		// System.out.println("list2.size()" + list2.size());
		// System.out.println(list2.get(0));
		// System.out.println(list2.get(1));
		// cpuDaoImpl.deleteCPUMessage(date2, prefix);

		// 测试对mem表的操作
		// MemDaoImpl memDaoImpl = new MemDaoImpl();
		// MemoryMessage memoryMessage = new User1Mem();
		// Date now = new Date();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd
		// HH:mm:ss");
		// String date = dateFormat.format(now);
		// memoryMessage.setId(3);
		// memoryMessage.setDate(date);
		// memoryMessage.setActualFree(50);
		// memoryMessage.setActualUsed(50);
		// memoryMessage.setCountMem(150);
		// memoryMessage.setUsedPercent(50);
		// memoryMessage.setUsedPercent(85);
		// memDaoImpl.addMemMessage(memoryMessage);
		// String prefix = "wgw";
		// String date2 = "2017/04/20";
		// List<MemoryMessage> list = memDaoImpl.find(date2, prefix);
		// System.out.println("list size():" + list.size());
		// System.out.println(list.get(0));
		// System.out.println(list.get(1));
		// List<MemoryMessage> list2 = memDaoImpl.findException(80, "wgw");
		// System.out.println("list2.size()" + list2.size());
		// System.out.println(list2.get(0));
		// System.out.println(list2.get(1));
		// memDaoImpl.deleteMemMessage(date2, prefix);

		// 测试对OS表的操作
		// OSDaoImpl osDaoImpl = new OSDaoImpl();
		// OSMessage osMessage = new User1OS();
		// osMessage.setId(1);
		// Date now = new Date();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String date = dateFormat.format(now);
		// osMessage.setDate(date);
		// osMessage.setName("wdww");
		// osDaoImpl.addCPUMessage(osMessage);
		// String date1 = "2017/04/20";
		// String prefix = "wgw";
		// OSMessage osMessage2 = osDaoImpl.find(date1, prefix);
		// System.out.println(osMessage2);
		// osDaoImpl.deleteOSMessage(date1, prefix);
		// OSMessage osMessage = osDaoImpl.findNew("wgw");
		// System.out.println(osMessage);

		// 测试对file表的操作
		FileDaoImpl fileDaoImpl = new FileDaoImpl();
		// FileMessage fileMessage = new User1File();
		// Date now = new Date();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String date = dateFormat.format(now);
		// fileMessage.setId(3);
		// fileMessage.setDate(date);
		// fileMessage.setFileName("F:");
		// fileMessage.setFilePercent(50);
		// fileDaoImpl.addFileMessage(fileMessage);
		// List<FileMessage> list = fileDaoImpl.find("2017/04/20", "wgw");
		// System.out.println("list size:" + list.size());
		// List<FileMessage> list2 = fileDaoImpl.findNew("wgw");
		// System.out.println("list2 size:" + list2.size());
		// System.out.println(list2.get(0));
		// List<FileMessage> list3 = fileDaoImpl.findOver("wgw");
		// System.out.println("list3 size:" + list3.size());
		// System.out.println(list3.get(0));
		// System.out.println(list3.get(1));
		// System.out.println(list3.get(2));
		// fileDaoImpl.deleteFileMessage("2017/04/20", "wgw");

		// 测试对inet表的操作
		// InetDaoImpl impl = new InetDaoImpl();
		// Date now = new Date();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String date = dateFormat.format(now);
		// InterMessage interMessage = new User1Inet();
		// interMessage.setId(2);
		// interMessage.setName("dev3");
		// interMessage.setDate(date);
		// impl.addInetMessage(interMessage);
		// List<InterMessage> list1=impl.find("2017/04/20", "wgw");
		// System.out.println("list1 size:"+list1.size());
		// System.out.println(list1.get(0));
		// List<InterMessage> list2=impl.findNew("wgw");
		// System.out.println("list2 size:"+list2.size());
		// System.out.println(list2.get(0));
		// String name="wgw";
		// String password="wgw196602140";
		// ILoginService loginService = new LoginServiceImpl();
		// boolean judge = loginService.isSuccessLogin(name, password);
		// System.out.println(judge);
		// UserDaoImpl sDaoImpl=new UserDaoImpl();
		// User user=sDaoImpl.findByPrefix("wgw");
		// System.out.println(user.getName()+":"+user.getIp());

//		MemoryMessage memoryMessage = new MemDaoImpl().findNew("wgw");
//		System.out.println(memoryMessage);
		CPUMessage cpuMessage=new CPUDaoImpl().findNew("wgw");
		System.out.println(cpuMessage.getDate());
		
	}

}
