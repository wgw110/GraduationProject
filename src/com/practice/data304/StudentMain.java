package com.practice.data304;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class StudentMain {
	public static void main(String[] args) {
		// ��ȡhibernate.cfg.xml�ļ�
		Configuration configuration = new Configuration().configure();
		// ����sessionFactory����
		SessionFactory factory = configuration.buildSessionFactory();
		// ȡ��session����
		Session session = null;
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = dateFormat.format(now);
		try {
			session = factory.openSession();
			// ��������
			session.beginTransaction();
			Student student = new Student();
			 student.setId(1001);
			student.setName("wwwwwww");
			student.setAge(25);
			// student.setId(2013217155);
			student.setLocalAddress("����ʡ�����к�˳��");
			student.setDate(date);
			session.save(student);
			// �ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// ����ع�
			session.getTransaction().rollback();
		} finally {
			session.close();
			factory.close();
		}
	}

}
