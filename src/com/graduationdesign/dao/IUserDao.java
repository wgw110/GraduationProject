package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.po.User;

public interface IUserDao {
	// ����û�
	void adduser(User user);

	// �����������������Ϣ
	User findByName(String name);

	// ����ip��ַ�����û���Ϣ
	User findByIPAddress(String ip);

	// ���ݱ�ǰ׺��ѯ��Ϣ
	User findByPrefix(String prefix);

	// ��ѯuser���е������û�
	List<User> findAll();

	// �����û���Ϣ
	void updateUser(String name);

	// ɾ���û�
	void deleteUser(String ip);

}
