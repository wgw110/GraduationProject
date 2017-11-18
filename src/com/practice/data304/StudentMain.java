package com.practice.data304;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class StudentMain {
	public static void main(String[] args) {
		// 读取hibernate.cfg.xml文件
		Configuration configuration = new Configuration().configure();
		// 建立sessionFactory工厂
		SessionFactory factory = configuration.buildSessionFactory();
		// 取得session对象
		Session session = null;
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = dateFormat.format(now);
		try {
			session = factory.openSession();
			// 开启事务
			session.beginTransaction();
			Student student = new Student();
			 student.setId(1001);
			student.setName("wwwwwww");
			student.setAge(25);
			// student.setId(2013217155);
			student.setLocalAddress("河南省林州市河顺镇");
			student.setDate(date);
			session.save(student);
			// 提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 事务回滚
			session.getTransaction().rollback();
		} finally {
			session.close();
			factory.close();
		}
	}

}
