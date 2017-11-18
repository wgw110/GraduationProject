package com.graduationdesign.linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
/**
 * 
 * @author 王国伟
 * ssh2协议实现连接Linux操作系统并通过执行Linux的shell命令来获取相关信息
 *
 */
public class LinuxMessageImpl implements ILinuxMessage {

	@Override
	public String[] getLinuxMessageByShell(String ip, String userName, String password) {
		// 指明连接主机的IP地址
		Connection conn = new Connection(ip);
		Session ssh = null;
		String[] strings = new String[20];
		try {
			// 连接到主机
			conn.connect();
			// 使用用户名和密码校验
			boolean isconn = conn.authenticateWithPassword(userName, password);
			if (!isconn) {
				System.out.println("用户名称或者是密码不正确");
			} else {
				System.out.println("已经连接OK");
				ssh = conn.openSession();
				// 使用多个命令用分号隔开
				// ssh.execCommand("pwd;cd /tmp;mkdir hb;ls;ps -ef|grep
				// weblogic");
				String command = "vmstat 5 4;free -m;top -b -n 5|grep Cpu";
				ssh.execCommand(command);
				// 只允许使用一行命令，即ssh对象只能使用一次execCommand这个方法，多次使用则会出现异常
				// ssh.execCommand("mkdir hb");
				// 将屏幕上的文字全部打印出来
				InputStream is = new StreamGobbler(ssh.getStdout());
				BufferedReader brs = new BufferedReader(new InputStreamReader(is));
				int i = 0;
				while (true) {
					// 按行打印
					String line = brs.readLine();
					strings[i] = line;
					if (line == null) {
						break;
					}
					i++;
					System.out.println(line);
				}

			}
			// 连接的Session和Connection对象都需要关闭

			ssh.close();
			conn.close();
			System.out.println("连接关闭");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strings;
	}

}
