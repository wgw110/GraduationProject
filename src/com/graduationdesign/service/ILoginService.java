package com.graduationdesign.service;

import com.graduationdesign.po.User;
/**
 * 
 * @author ����ΰ
 *��¼�Լ�ע���ҵ���߼��ӿڣ���ҵ���߼��ӿ�ͨ�������ݿ��dao�㽻����δʵ�ֹ��ڵ�¼��ע���ҵ���߼�
 *
 */
public interface ILoginService {
	// �жϵ�¼�Ƿ�ɹ�
	boolean isSuccessLogin(String name, String password);

	// �û�ע����Ϣ���뵽user��֮��
	void register(User user);

	// �û��Ƿ��Ѿ�ע��
	boolean isUserRegister(String ip);

	// �û��ǳ��Ƿ�ռ��
	boolean isNameUsed(String name);

	// IP��ַ�Ƿ���Ч
	boolean isValid(String ip);

}
