package com.graduationdesign.hibernatefactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * 
 * @author ����ΰ
 * ThreadLocal�������治ͬ�߳��µ�Sessio���󣬱�֤��ͬ���߳�ӵ�в�ͬ��Session����
 * ͬʱ��֤ÿ���߳�ֻ����һ��Session����.ʵ�ֲ��裺
 * 1.��ȡherbinate�������ļ�herbinate.cfg.xml,Ȼ�������buildSessionFactory���������½�һ��SessionFactory����
 * 2.����ĳ���̵߳�����getSession���������������ж�THREAD_LOCAL�Ƿ��Ѿ����ڸ��̵߳�Session��������������򴴽�
 * ���̵߳�Session���󲢽�������Session�������THREAD_LOCAL��
 * 3.���ĳ���̲߳�����ҪSession���������ThreadLocal���Ƴ����������̵߳�Session����ر�
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
	//����THREAD_LOCAL�д洢��Sesssion���������
	public static int getSize(){
		return size;
	}

}
