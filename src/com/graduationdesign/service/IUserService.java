package com.graduationdesign.service;

import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.MemoryMessage;
/**
 * 
 * @author ����ΰ
 *�û�������Ϣ���г����߼�ҵ��
 *ͨ������ӿ���dao�ж����ݿ����Ӧ����������Ӹ�����߼�ҵ�񷽷�
 */
public interface IUserService {
	// ����IP��ַ��ѯ��ǰ׺
	String findPrefix(String ip);

	// ͳ��ĳ��ʱ����cpu��Ϣ��ƽ��ֵ
	CPUMessage find(String date, String prefix);

	// ͳ��ĳ��ʱ����MEM��Ϣ��ƽ��ֵ
	MemoryMessage findMem(String date, String prefix);
	//�����ҳ����
	

	// ɾ��ĳ��ʱ����cpu��Ϣ
	void deleteCPUMessage(String date, String prefix);

	// ɾ��ĳ��ʱ����Mem��Ϣ
	void deleteMemMessage(String date, String prefix);
}
