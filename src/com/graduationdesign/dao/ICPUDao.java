package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.po.CPUMessage;

public interface ICPUDao {
	// ��ĳ���û���cpu��Ϣ���в���cpu����
	void addCPUMessage(CPUMessage cpuMessage);

	// ����ĳ��ʱ���/�ε�cpu��Ϣ
	List<CPUMessage> find(String date, String prefix);

	// ɾ��ĳ��ʱ���/�ε�cpu��Ϣ
	void deleteCPUMessage(String date, String prefix);

	// ��ѯCPU��ʹ���ʴ���ĳ����ֵ�ļ�¼,����ѯ���е��쳣��Ϣ
	/**
	 * 
	 * @param critical
	 *            �ٽ�ֵ
	 * @param prefix
	 *            ǰ׺
	 * @return
	 */
	List<CPUMessage> findException(double critical, String prefix);

	// ��ѯ���µ�CPU��Ϣ(Ĭ���û���ѯ���Ǳ���Ŀǰ�洢�����µ�cpu��Ϣ)
	CPUMessage findNew(String prefix);

}
