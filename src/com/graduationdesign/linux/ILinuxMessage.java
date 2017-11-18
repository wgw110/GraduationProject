package com.graduationdesign.linux;

public interface ILinuxMessage {
	// 通过IP地址，Linux用户名，密码来调用shell命令获取Linux机器上的相关性能信息
	String[] getLinuxMessageByShell(String ip, String userName, String password);

}
