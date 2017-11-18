package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.po.InterMessage;

public interface IInetDao {
	// ��ĳ���û���inet��Ϣ���в���mem����
	void addInetMessage(InterMessage inetMessage);

	// ����ĳ��ʱ����inet��Ϣ
	List<InterMessage> find(String date, String prefix);

	// ɾ��ĳ��ʱ����inet��Ϣ
	void deleteInetMessage(String date, String prefix);

	// �������µ�inet��Ϣ
	List<InterMessage> findNew(String prefix);
}
