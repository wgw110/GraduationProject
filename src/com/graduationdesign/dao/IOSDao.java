package com.graduationdesign.dao;

import com.graduationdesign.po.OSMessage;

public interface IOSDao {
	// ��ĳ���û���os��Ϣ���в���mem����
	void addOSMessage(OSMessage osMessage);

	// ����ĳ��ʱ����OS��Ϣ
	OSMessage find(String date, String prefix);

	// ɾ��ĳ��ʱ���/�ε�OS��Ϣ
	void deleteOSMessage(String date, String prefix);

	// ��ѯ���ݿ��д洢�����µ�OS��Ϣ
	OSMessage findNew(String prefix);

}
