package com.practice.data304;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class UserMain {
	public static void main(String[] args) {
		// 读取hibernate.cfg.xml文件
		Configuration configuration = new Configuration().configure();
		// 建立sessionFactory工厂
		SessionFactory factory = configuration.buildSessionFactory();
		// 取得session对象
		Session session = null;
		try {
			session = factory.openSession();
			// 开启事务
			session.beginTransaction();
			User user = new User();
	//		 user.setId(1005);
			user.setName("lsqss");
			user.setPassword("wgw196602140");
			session.save(user);
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
