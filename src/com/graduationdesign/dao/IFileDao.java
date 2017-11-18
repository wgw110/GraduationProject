package com.graduationdesign.dao;

import java.util.Date;
import java.util.List;

import com.graduationdesign.po.FileMessage;

public interface IFileDao {
	// ����в����ļ�ϵͳ��Ϣ
	void addFileMessage(FileMessage fileMessage);

	// ����ĳ��ʱ���ļ�ϵͳ��Ϣ
	List<FileMessage> find(String date, String prefix);

	// ɾ��ĳ��ʱ����ļ���Ϣ
	void deleteFileMessage(String date, String prefix);

	// ���ұ������µļ�¼
	List<FileMessage> findNew(String prefix);
	
	//���ұ���C��ռ���ʹ��ߵĵļ�¼
	List<FileMessage> findOver(String prefix);


}
