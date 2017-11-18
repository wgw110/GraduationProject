package com.practice.data304;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class UserMain {
	public static void main(String[] args) {
		// ��ȡhibernate.cfg.xml�ļ�
		Configuration configuration = new Configuration().configure();
		// ����sessionFactory����
		SessionFactory factory = configuration.buildSessionFactory();
		// ȡ��session����
		Session session = null;
		try {
			session = factory.openSession();
			// ��������
			session.beginTransaction();
			User user = new User();
	//		 user.setId(1005);
			user.setName("lsqss");
			user.setPassword("wgw196602140");
			session.save(user);
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
