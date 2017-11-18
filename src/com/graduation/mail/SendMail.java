package com.graduation.mail;
 
/**
 * 通过发送邮件的方式将相关的性能信息或者警告信息发送给客户（包括附件）
 * 可能会出现对方收不到邮件的情况，这是因为发送的邮件有时候会被当做垃圾邮件从而被拒收
 *  将邮件抄送自己一份就可以解决这个问题
 */
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
	private static String receivePersonAccount = "1023076445@qq.com";
	private static String sendPersonSMTPHost = "smtp.163.com";
	// SSL连接密码
	private static String SSLPersonPassword = "Wgw196602140";
	private static String smtpPort = "587";

	public static void main(String[] args) throws MessagingException, IOException {
		Properties properties = new Properties();
		// 使用的协议
		properties.setProperty("mail.transport.protocol", "smtp");
		// 发件人邮箱的SMTP地址
		properties.setProperty("mail.smtp.host", sendPersonSMTPHost);
		// 需要请求认证
		properties.setProperty("mail.smtp.auth", "false");
		// 开启SSL安全连接
		properties.setProperty("mail.smtp.port", smtpPort);
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.socketFactory.port", smtpPort);
		properties.setProperty("mail.smtp.localhost", "mail.digu.com");
		// 创建回话对象Session
		Session session = Session.getDefaultInstance(properties);
		// 设置为debug模式，可以看到的发送log
		session.setDebug(true);
		// 创建邮件
		MimeMessage email = createEmail(session);
		// 通过Session获取邮件传输对象
		Transport transport = session.getTransport();
		// 使用邮箱账号与SSL密码连接邮件服务器
		transport.connect(sendPersonAccount, SSLPersonPassword);
		// 发送邮件
		transport.sendMessage(email, email.getAllRecipients());
		// 关闭连接
		transport.close();
	}

	private static MimeMessage createEmail(Session session) throws MessagingException, IOException {
		// 创建一份邮件
		MimeMessage email = new MimeMessage(session);
		// 设置邮件的相关信息
		email.setFrom(new InternetAddress(sendPersonAccount, "监控服务器", "UTF-8"));
		email.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receivePersonAccount, "用户", "UTF-8"));
		email.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(sendPersonAccount, "用户", "UTF-8"));
		// 标题
		email.setSubject("性能分析信息", "UTF-8");
		// 正文
		// 创建图片节点
		String imageSource = "Picture//小鸟Bird1234.jpg";
		MimeBodyPart image = new MimeBodyPart();
		// 读取本地文件
		DataHandler dHandler = new DataHandler(new FileDataSource(imageSource));
		// 将图片数据添加到节点
		image.setDataHandler(dHandler);
		// 为节点数据设置唯一编号
		image.setFileName(MimeUtility.encodeText(dHandler.getName(), "gbk", null));
		image.setContentID("image_fairy_tail");
		// 创建文本节点
		MimeBodyPart text = new MimeBodyPart();
		// 这里添加图片的方式是将整个图片包含到邮件内容中
		text.setContent("这是一张图片<br/><img src='cid:image_fairy_tail'/>", "text/html;charset=UTF-8");
		// 将文本与图片节点混合成一个节点
		MimeMultipart mm_text_image = new MimeMultipart();
		mm_text_image.addBodyPart(text);
		mm_text_image.addBodyPart(image);
		// 关联关系
		mm_text_image.setSubType("relate");
		// 把混合节点封装成普通节点
		MimeBodyPart text_image = new MimeBodyPart();
		text_image.setContent(mm_text_image);
		// 创建附件节点
		MimeBodyPart text2 = new MimeBodyPart();
		text2.setContent("使用JavaMail创建的带附件的邮件", "text/html;charset=UTF-8");
		String attachmentSource = "papers//Java开发工程师(1).doc";
		MimeBodyPart attachment = new MimeBodyPart();
		DataHandler dhHandler = new DataHandler(new FileDataSource(attachmentSource));
		attachment.setDataHandler(dhHandler);
		// 设置附件的文件名
		attachment.setFileName(MimeUtility.encodeText(dhHandler.getName(), "gbk", null));
		// 设置（文本+图片）和 附件 的关系（合成一个大的混合“节点”）
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text_image);
		mm.addBodyPart(attachment); // 如果有多个附件，可以创建多个多次添加
		mm.setSubType("mixed"); // 混合关系
		email.setContent(mm);
		// 保存相关邮件的设置
		email.saveChanges();
		// 将该邮件保存到本地
		OutputStream out = new FileOutputStream("E:\\MyEmail.eml");
		email.writeTo(out);
		out.flush();
		out.close();
		return email;
	}

}
