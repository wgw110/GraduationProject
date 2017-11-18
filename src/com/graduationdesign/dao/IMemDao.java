package com.graduationdesign.dao;

import java.util.Date;
import java.util.List;

import com.graduationdesign.po.MemoryMessage;

public interface IMemDao {
	// ��ĳ���û���mem��Ϣ���в���mem����
	void addMemMessage(MemoryMessage memMessage);

	// ����ĳ��ʱ����mem��Ϣ
	List<MemoryMessage> find(String date, String prefix);

	// ɾ��ĳ��ʱ���/�ε�mem��Ϣ
	void deleteMemMessage(String date, String prefix);

	// Ѱ�ұ����쳣��¼
	List<MemoryMessage> findException(double critical, String prefix);

	// ��ѯ�������µ�mem��Ϣ
	MemoryMessage findNew(String prefix);

}
