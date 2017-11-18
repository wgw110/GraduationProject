package com.graduationdesign.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.graduationdesign.hibernatefactory.HerbinateSessionFactory;
import com.graduationdesign.po.InterMessage;
import com.graduationdesign.user.User1Inet;
import com.graduationdesign.user.User2Inet;

public class InetDaoImpl implements IInetDao {

	@Override
	public void addInetMessage(InterMessage inetMessage) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(inetMessage);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			HerbinateSessionFactory.closeSession();
		}

	}

	@Override
	public List<InterMessage> find(String date, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<InterMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1Inet.class.getName();
				break;
			case "lsq":
				table = User2Inet.class.getName();
			default:
				break;
			}
			hq.append("from ").append(table).append(" where date like :date");
			Query query = session.createQuery(hq.toString());
			query.setString("date", date + "%");
			list = query.list();
			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();

		} finally {
			HerbinateSessionFactory.closeSession();
		}
		return list;
	}

	@Override
	public void deleteInetMessage(String date, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<InterMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1Inet.class.getName();
				break;
			case "lsq":
				table = User2Inet.class.getName();
			default:
				break;
			}
			hq.append("from ").append(table).append(" where date like :date");
			Query query = session.createQuery(hq.toString());
			query.setString("date", date + "%");
			list = query.list();
			for (InterMessage inetMessage : list) {
				inetMessage.setId(inetMessage.getId());
				session.delete(inetMessage);
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
	public List<InterMessage> findNew(String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<InterMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			StringBuilder hq2 = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1Inet.class.getName();
				break;
			case "lsq":
				table = User2Inet.class.getName();
			default:
				break;
			}
			hq.append("from ").append(table);
			Query query = session.createQuery(hq.toString());
			list = query.list();
			String date = list.get(list.size() - 1).getDate();
			list.clear();
			hq2.append("from ").append(table).append(" where date=:date");
			Query query2 = session.createQuery(hq2.toString());
			query2.setString("date", date);
			list = query2.list();
			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();

		} finally {
			HerbinateSessionFactory.closeSession();
		}
		return list;
	}

}
