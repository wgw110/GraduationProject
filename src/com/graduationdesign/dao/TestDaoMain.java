package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.MemoryMessage;
import com.graduationdesign.po.OSMessage;
import com.graduationdesign.po.User;

public class TestDaoMain {

	public static void main(String[] args) {
		// ��������û�����ѯ�û��������û���Ϣ��ɾ���û���Ϣ����
		// User user = new User();
		// user.setIp("172.18.3.3");
		// user.setMail("1023076445@qq.com");
		// user.setName("·����");
		// user.setPassword("2013217155");
		// UserDaoImpl userDaoImpl = new UserDaoImpl();
		// userDaoImpl.adduser(user);
		// userDaoImpl=new UserDaoImpl();
		// String ip = "172.18.3.3";
		// User user = userDaoImpl.findByIPAddress(ip);
		// System.out.println(user);
		// String name = "·����";
		// User user2 = userDaoImpl.findByNmae(name);
		// System.out.println(user2);
		// userDaoImpl = new UserDaoImpl();
		// userDaoImpl.updateUser("·����");
		// userDaoImpl.deleteUser("172.18.3.3");

		// ������ͬ�û���Ӧ��cpu��Ϣ����������ݣ���ѯ�����Լ�ɾ�����ݣ������û���Ӧ�ı��������ǰ׺������
		// �����ʱ���ݴ�����ʵ����Ķ���Ĳ�ͬ�����������ļ��������Զ���������ӵ���Ӧ������.
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
		// ��������ʱ����Ҫ�Ǹ����û���user���û���Ӧ��ip��ַ�Լ�ǰ׺������sql��䣬֮��sql��侭�����ļ��������Զ�����Ӧ�ı�֮��
		// ��ɲ�ѯ���ݵĲ�������ɾ�����ݵĲ����������
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

		// ���Զ�mem��Ĳ���
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

		// ���Զ�OS��Ĳ���
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

		// ���Զ�file��Ĳ���
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

		// ���Զ�inet��Ĳ���
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
