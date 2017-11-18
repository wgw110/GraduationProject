package com.graduationdesign.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.graduationdesign.hibernatefactory.HerbinateSessionFactory;
import com.graduationdesign.po.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public void adduser(User user) {
		// TODO Auto-generated method stub
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			HerbinateSessionFactory.closeSession();
		}

	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<User> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			hq.append("from ").append(User.class.getName()).append(" where name=:name");
			Query query = session.createQuery(hq.toString());
			query.setString("name", name);
			list = query.list();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			HerbinateSessionFactory.closeSession();
		}
		// return list.get(0);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

	@Override
	public User findByIPAddress(String ip) {
		// TODO Auto-generated method stub
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<User> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			hq.append("from ").append(User.class.getName()).append(" where ip=:ip");
			Query query = session.createQuery(hq.toString());
			query.setString("ip", ip);
			list = query.list();
			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {

			HerbinateSessionFactory.closeSession();

		}
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

	// 这里需要考虑一下更新或删除的用户不存在时候的情况
	@Override
	public void updateUser(String name) {
		// TODO Auto-generated method stub
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<User> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			hq.append("from ").append(User.class.getName()).append(" where name=:name");
			Query query = session.createQuery(hq.toString());
			query.setString("name", name);
			list = query.list();
			if (list.size() == 0) {
				return;
			}
			for (User user : list) {
				user.setIp(user.getIp());
				user.setName("王国伟");
				user.setPassword("2013217155");
				user.setMail("1023076445@qq.com");
				user.setPrefix("wgw");
				session.update(user);
			}

			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			HerbinateSessionFactory.closeSession();
		}

	}

	@Override
	public void deleteUser(String ip) {
		// TODO Auto-generated method stub
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<User> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			hq.append("from ").append(User.class.getName()).append(" where ip=:ip");
			Query query = session.createQuery(hq.toString());
			query.setString("ip", ip);
			list = query.list();
			if (list.size() == 0) {
				return;
			}
			for (User user : list) {
				user.setIp(user.getIp());
				session.delete(user);
			}

			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			HerbinateSessionFactory.closeSession();
		}

	}

	@Override
	public User findByPrefix(String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<User> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			hq.append("from ").append(User.class.getName()).append(" where prefix=:prefix");
			Query query = session.createQuery(hq.toString());
			query.setString("prefix", prefix);
			list = query.list();
			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {

			HerbinateSessionFactory.closeSession();

		}
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public List<User> findAll() {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<User> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			hq.append("from ").append(User.class.getName());
			Query query = session.createQuery(hq.toString());
			list = query.list();
			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {

			HerbinateSessionFactory.closeSession();

		}
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

}
