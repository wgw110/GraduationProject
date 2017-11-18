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
 * @author ����ΰ
 * ssh2Э��ʵ������Linux����ϵͳ��ͨ��ִ��Linux��shell��������ȡ�����Ϣ
 *
 */
public class LinuxMessageImpl implements ILinuxMessage {

	@Override
	public String[] getLinuxMessageByShell(String ip, String userName, String password) {
		// ָ������������IP��ַ
		Connection conn = new Connection(ip);
		Session ssh = null;
		String[] strings = new String[20];
		try {
			// ���ӵ�����
			conn.connect();
			// ʹ���û���������У��
			boolean isconn = conn.authenticateWithPassword(userName, password);
			if (!isconn) {
				System.out.println("�û����ƻ��������벻��ȷ");
			} else {
				System.out.println("�Ѿ�����OK");
				ssh = conn.openSession();
				// ʹ�ö�������÷ֺŸ���
				// ssh.execCommand("pwd;cd /tmp;mkdir hb;ls;ps -ef|grep
				// weblogic");
				String command = "vmstat 5 4;free -m;top -b -n 5|grep Cpu";
				ssh.execCommand(command);
				// ֻ����ʹ��һ�������ssh����ֻ��ʹ��һ��execCommand������������ʹ���������쳣
				// ssh.execCommand("mkdir hb");
				// ����Ļ�ϵ�����ȫ����ӡ����
				InputStream is = new StreamGobbler(ssh.getStdout());
				BufferedReader brs = new BufferedReader(new InputStreamReader(is));
				int i = 0;
				while (true) {
					// ���д�ӡ
					String line = brs.readLine();
					strings[i] = line;
					if (line == null) {
						break;
					}
					i++;
					System.out.println(line);
				}

			}
			// ���ӵ�Session��Connection������Ҫ�ر�

			ssh.close();
			conn.close();
			System.out.println("���ӹر�");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strings;
	}

}
