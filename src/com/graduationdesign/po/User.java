package com.graduationdesign.po;

/**
 * 
 * @author ����ΰ �û���Ϣ�࣬������صĿͻ��˵���Ϣ
 *
 */
public class User {

	// �û����˺�
	private String name;
	// �û�������
	private String password;
	// �û�����
	private String mail;
	// �û�IP��ַ
	private String ip;
	// �û���Ӧ�ı��ǰ׺,ͨ����ǰ׺��ȷ��ÿ���û�ʹ�õı�
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
		return "�˺ţ�" + name + ",���룺" + ",ip��ַ:" + ip + ",�����ַ��" + mail + ",ǰ׺��" + prefix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
