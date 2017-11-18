package com.practice.data304;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{
	private static SessionFactory sessionFactory;
	static{
		      try{
		        // 读取hibernate.cfg.xml文件
				Configuration configuration = new Configuration().configure();
				// 建立sessionFactory工厂
				sessionFactory = configuration.buildSessionFactory();
				// 取得session对象
		      }catch(Exception e){
		    	 e.printStackTrace();
		      }
	}
	public static Session createSession(){
		Session session=sessionFactory.openSession();
		return session;
	}
}
