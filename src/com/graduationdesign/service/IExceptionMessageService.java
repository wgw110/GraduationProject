package com.graduationdesign.service;

import java.io.IOException;

import javax.mail.MessagingException;

/**
 * 
 * @author 王国伟 该接口主要是对异常性能信息进行操作的业务逻辑接口
 *
 */
public interface IExceptionMessageService {
	// 将每个用户的异常CPU信息以及异常内存信息分别存储在一张excel表中
	void storeCPUExceptionMessage();

	void storeMemExceptionMessage();

	// 将异常性能信息通过邮件报告给用户
	void sendExceptionByMail() throws MessagingException, IOException;

}
