package com.practice.data304;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.graduationdesign.hibernatefactory.HerbinateSessionFactory;



public class Test {
	public static void main(String[] args) {
		//���������ļ��Զ��������ݿ��еı�
//		Configuration configuration=new Configuration().configure();
//		SchemaExport schemaExport=new SchemaExport(configuration);
//		schemaExport.create(false, true);
		Session session=null;
		try{
		session=HerbinateSessionFactory.getSession();
		System.out.println("size:"+HerbinateSessionFactory.getSize());
		session.beginTransaction();
	    Class class1=new Class();
	    class1.setId(1001);
	    class1.setAge(20);
	    class1.setLocalAddress("����ʡ�������Ӵ�");
	    class1.setMarried(true);
	    class1.setName("����ΰ");
	    session.save(class1);
	    session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}finally{
			HerbinateSessionFactory.closeSession();
			System.out.println("size:"+HerbinateSessionFactory.getSize());
		}
	    
	}

}
