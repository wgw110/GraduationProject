package com.graduationdesign.linux;

public interface ILinuxMessage {
	// ͨ��IP��ַ��Linux�û���������������shell�����ȡLinux�����ϵ����������Ϣ
	String[] getLinuxMessageByShell(String ip, String userName, String password);

}
