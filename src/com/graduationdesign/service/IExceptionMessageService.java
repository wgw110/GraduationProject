package com.graduationdesign.service;

import java.io.IOException;

import javax.mail.MessagingException;

/**
 * 
 * @author ����ΰ �ýӿ���Ҫ�Ƕ��쳣������Ϣ���в�����ҵ���߼��ӿ�
 *
 */
public interface IExceptionMessageService {
	// ��ÿ���û����쳣CPU��Ϣ�Լ��쳣�ڴ���Ϣ�ֱ�洢��һ��excel����
	void storeCPUExceptionMessage();

	void storeMemExceptionMessage();

	// ���쳣������Ϣͨ���ʼ�������û�
	void sendExceptionByMail() throws MessagingException, IOException;

}
