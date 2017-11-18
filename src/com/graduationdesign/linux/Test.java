package com.graduationdesign.linux;

public class Test {
	public static void main(String[] args) {
		String ip = "172.19.182.49";
		String userName = "wgw";
		String password = "wgw196602140";
		LinuxMessageImpl linuxMessageImpl = new LinuxMessageImpl();
		String asString[] = linuxMessageImpl.getLinuxMessageByShell(ip, userName, password);
		for (String s : asString) {
			if (s != null) {
				System.out.println(s);
			}

		}
	}

}
