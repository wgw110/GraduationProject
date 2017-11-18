package com.graduationdesign.hibernatefactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * 
 * @author 王国伟
 * ThreadLocal用来保存不同线程下的Sessio对象，保证不同的线程拥有不同的Session对象，
 * 同时保证每个线程只能有一个Session对象.实现步骤：
 * 1.读取herbinate的配置文件herbinate.cfg.xml,然后调用其buildSessionFactory（）方法新建一个SessionFactory对象
 * 2.对于某个线程调用其getSession（）方法，首先判断THREAD_LOCAL是否已经存在该线程的Session对象，如果不存在则创建
 * 该线程的Session对象并将创建的Session对象放在THREAD_LOCAL中
 * 3.如果某个线程不再需要Session对象，则将其从ThreadLocal中移除，并将该线程的Session对象关闭
 *
 */
public class HerbinateSessionFactory {
	private static final ThreadLocal<Session> THREAD_LOCAL = new ThreadLocal<>();
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	private static int size=0;
	static {
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Error Creating SessionFactory!!!");
			e.printStackTrace();
		}
	}

	private HerbinateSessionFactory() {
	}

	public static Session getSession() {
		Session session = (Session) THREAD_LOCAL.get();
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			} else {
				session = sessionFactory.openSession();
				size++;
				THREAD_LOCAL.set(session);
			}

		}
		return session;

	}

	private static void rebuildSessionFactory() {
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Error Creating SessionFactory!!!");
			e.printStackTrace();
		}

	}

	public static void closeSession() {
		Session session = (Session) THREAD_LOCAL.get();
		THREAD_LOCAL.set(null);
		size--;
		if (session != null) {
			session.close();
		}
	}
	//返回THREAD_LOCAL中存储的Sesssion对象的数量
	public static int getSize(){
		return size;
	}

}
