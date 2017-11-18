package com.graduation.message301;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class Test {
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.library.path"));
		 Sigar sigar = new Sigar();

	        FileSystem fslist[] = null;
			try {
				fslist = sigar.getFileSystemList();
			} catch (SigarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(fslist.length);

	        for (int i = 0; i < fslist.length; i++) {

	            System.out.println("�������̷�����" + i);

	            FileSystem fs = fslist[i];

	            // �������̷�����

	            System.out.println("�̷�����:    " + fs.getDevName());

	            // �������̷�����

	            System.out.println("�̷�·��:    " + fs.getDirName());

	            System.out.println("�̷���־:    " + fs.getFlags());//

	            // �ļ�ϵͳ���ͣ����� FAT32��NTFS

	            System.out.println("�̷�����:    " + fs.getSysTypeName());

	            // �ļ�ϵͳ�����������籾��Ӳ�̡������������ļ�ϵͳ��

	            System.out.println("�̷�������:    " + fs.getTypeName());

	            // �ļ�ϵͳ����

	            System.out.println("�̷��ļ�ϵͳ����:    " + fs.getType());

	            FileSystemUsage usage = null;
	            try {
					usage = sigar.getFileSystemUsage(fs.getDirName());
				} catch (SigarException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            switch (fs.getType()) {

	            case 0: // TYPE_UNKNOWN ��δ֪

	                break;

	            case 1: // TYPE_NONE

	                break;

	            case 2: // TYPE_LOCAL_DISK : ����Ӳ��

	                // �ļ�ϵͳ�ܴ�С

	                System.out.println(fs.getDevName() + "�ܴ�С:    " + usage.getTotal() + "KB");

	                // �ļ�ϵͳʣ���С

	                System.out.println(fs.getDevName() + "ʣ���С:    " + usage.getFree() + "KB");

	                // �ļ�ϵͳ���ô�С

	                System.out.println(fs.getDevName() + "���ô�С:    " + usage.getAvail() + "KB");

	                // �ļ�ϵͳ�Ѿ�ʹ����

	                System.out.println(fs.getDevName() + "�Ѿ�ʹ����:    " + usage.getUsed() + "KB");

	                double usePercent = usage.getUsePercent() * 100D;

	                // �ļ�ϵͳ��Դ��������

	                System.out.println(fs.getDevName() + "��Դ��������:    " + usePercent + "%");

	                break;
	            case 3:// TYPE_NETWORK ������

	                break;

	            case 4:// TYPE_RAM_DISK ������

	                break;

	            case 5:// TYPE_CDROM ������

	                break;

	            case 6:// TYPE_SWAP ��ҳ�潻��

	                break;

	            }

	            System.out.println(fs.getDevName() + "������    " + usage.getDiskReads());

	            System.out.println(fs.getDevName() + "д�룺    " + usage.getDiskWrites());

	        }
      
	}

}
