package com.graduationdesign.support;
/*ͨ�������ʼ��ķ�ʽ����ص�������Ϣ���߾�����Ϣ���͸��ͻ�������������*���ܻ���ֶԷ��ղ����ʼ��������������Ϊ���͵��ʼ���ʱ��ᱻ���������ʼ��Ӷ�������*���ʼ������Լ�һ�ݾͿ��Խ���������*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class SendMail {
	private static String sendPersonAccount = "18119905567@163.com";
	private static String sendPersonPassword = "wgw196602140";
	// private static String receivePersonAccount = "1023076445@qq.com";
	private static String sendPersonSMTPHost = "smtp.163.com";
	// SSL��������
	private static String SSLPersonPassword = "Wgw196602140";
	private static String smtpPort = "587";

	private static MimeMessage createEmail(Session session, String name, String mail, String[] source)
			throws MessagingException, IOException {
		// ����һ���ʼ�
		MimeMessage email = new MimeMessage(session);
		// �����ʼ��������Ϣ
		email.setFrom(new InternetAddress(sendPersonAccount, "��ط�����", "UTF-8"));
		email.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mail, "�û�", "UTF-8"));
		email.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(sendPersonAccount, "�û�", "UTF-8"));
		// ����
		email.setSubject("�����쳣������Ϣ", "UTF-8");
		// ����
		// ����ͼƬ�ڵ�
		String imageSource = "Picture//warn.jpg";
		MimeBodyPart image = new MimeBodyPart();
		// ��ȡ�����ļ�
		DataHandler dHandler = new DataHandler(new FileDataSource(imageSource));
		// ��ͼƬ������ӵ��ڵ�
		image.setDataHandler(dHandler);
		// Ϊ�ڵ���������Ψһ���
		image.setFileName(MimeUtility.encodeText(dHandler.getName(), "gbk", null));
		image.setContentID("image_fairy_tail");
		// �����ı��ڵ�
		MimeBodyPart text = new MimeBodyPart();
		// �������ͼƬ�ķ�ʽ�ǽ�����ͼƬ�������ʼ�������
		text.setContent("����һ��ͼƬ<br/><img src='cid:image_fairy_tail'/>", "text/html;charset=UTF-8");
		// ���ı���ͼƬ�ڵ��ϳ�һ���ڵ�
		MimeMultipart mm_text_image = new MimeMultipart();
		mm_text_image.addBodyPart(text);
		mm_text_image.addBodyPart(image);
		// ������ϵ
		mm_text_image.setSubType("relate");
		// �ѻ�Ͻڵ��װ����ͨ�ڵ�
		MimeBodyPart text_image = new MimeBodyPart();
		text_image.setContent(mm_text_image);
		// ���������ڵ�
		MimeBodyPart text2 = new MimeBodyPart();
		text2.setContent("ʹ��JavaMail�����Ĵ��������ʼ�", "text/html;charset=UTF-8");
		String attachmentSource = "C:\\Users\\����ΰ\\Desktop\\����\\excel\\wgw_cpuException.xls";
		MimeBodyPart attachment = new MimeBodyPart();
		DataHandler dhHandler = new DataHandler(new FileDataSource(source[0]));
		attachment.setDataHandler(dhHandler);
		// ���ø������ļ���
		attachment.setFileName(MimeUtility.encodeText("�ڴ��쳣��Ϣ��.xls", "gbk", null));

		MimeBodyPart text3 = new MimeBodyPart();
		text3.setContent("ʹ��JavaMail�����Ĵ��������ʼ�", "text/html;charset=UTF-8");
		MimeBodyPart attachment2 = new MimeBodyPart();
		DataHandler dhHandler2 = new DataHandler(new FileDataSource(source[1]));
		attachment2.setDataHandler(dhHandler2);
		// ���ø������ļ���
		attachment2.setFileName(MimeUtility.encodeText("cpu�쳣��Ϣ��.xls", "gbk", null));
		// ���ã��ı�+ͼƬ���� ���� �Ĺ�ϵ���ϳ�һ����Ļ�ϡ��ڵ㡱��
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text_image);
		mm.addBodyPart(attachment); // ����ж�����������Դ������������
		mm.addBodyPart(attachment2);
		mm.setSubType("mixed"); // ��Ϲ�ϵ
		email.setContent(mm);
		// ��������ʼ�������
		email.saveChanges();
		// �����ʼ����浽����
		OutputStream out = new FileOutputStream("E:\\MyEmail.eml");
		email.writeTo(out);
		out.flush();
		out.close();
		return email;
	}

	public void send(String name, String mail, String[] source) throws MessagingException, IOException {
		Properties properties = new Properties();
		// ʹ�õ�Э��
		properties.setProperty("mail.transport.protocol", "smtp");
		// �����������SMTP��ַ
		properties.setProperty("mail.smtp.host", sendPersonSMTPHost);
		// ��Ҫ������֤
		properties.setProperty("mail.smtp.auth", "false");
		// ����SSL��ȫ����
		properties.setProperty("mail.smtp.port", smtpPort);
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.socketFactory.port", smtpPort);
		properties.setProperty("mail.smtp.localhost", "mail.digu.com");
		// �����ػ�����Session
		Session session = Session.getDefaultInstance(properties);
		// ����Ϊdebugģʽ�����Կ����ķ���log
		session.setDebug(true);
		// �����ʼ�
		MimeMessage email = createEmail(session, name, mail, source);
		// ͨ��Session��ȡ�ʼ��������
		Transport transport = session.getTransport();
		// ʹ�������˺���SSL���������ʼ�������
		transport.connect(sendPersonAccount, SSLPersonPassword);
		// �����ʼ�
		transport.sendMessage(email, email.getAllRecipients());
		// �ر�����
		transport.close();
	}

}
