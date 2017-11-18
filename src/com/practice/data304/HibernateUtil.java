package com.practice.data304;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{
	private static SessionFactory sessionFactory;
	static{
		      try{
		        // ��ȡhibernate.cfg.xml�ļ�
				Configuration configuration = new Configuration().configure();
				// ����sessionFactory����
				sessionFactory = configuration.buildSessionFactory();
				// ȡ��session����
		      }catch(Exception e){
		    	 e.printStackTrace();
		      }
	}
	public static Session createSession(){
		Session session=sessionFactory.openSession();
		return session;
	}
}
