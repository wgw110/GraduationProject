package com.graduationdesign.po;

/**
 * 
 * @author 王国伟 用户信息类，即被监控的客户端的信息
 *
 */
public class User {

	// 用户的账号
	private String name;
	// 用户的密码
	private String password;
	// 用户邮箱
	private String mail;
	// 用户IP地址
	private String ip;
	// 用户对应的表的前缀,通过该前缀来确定每个用户使用的表
	private String prefix;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "账号：" + name + ",密码：" + ",ip地址:" + ip + ",邮箱地址：" + mail + ",前缀：" + prefix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
