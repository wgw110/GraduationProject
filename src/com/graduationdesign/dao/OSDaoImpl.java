package com.graduationdesign.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.graduationdesign.hibernatefactory.HerbinateSessionFactory;
import com.graduationdesign.po.OSMessage;
import com.graduationdesign.user.User1OS;
import com.graduationdesign.user.User2OS;

public class OSDaoImpl implements IOSDao {

	@Override
	public void addOSMessage(OSMessage osMessage) {
		// TODO Auto-generated method stub
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(osMessage);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			HerbinateSessionFactory.closeSession();
		}

	}

	@Override
	public OSMessage find(String date, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<OSMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1OS.class.getName();
				break;
			case "lsq":
				table = User2OS.class.getName();
			default:
				break;
			}
			// 精确查找某个时间的CPUMessage信息
			// hq.append("from ").append(table).append(" where date=:date");
			// 查询符合某个时间格式的CPUMessage信息，既可以查询某个时间段的信息
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
		return list.get(0);
	}

	@Override
	public void deleteOSMessage(String date, String prefix) {
		// TODO Auto-generated method stub
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<OSMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1OS.class.getName();
				break;
			case "lsq":
				table = User2OS.class.getName();
			default:
				break;
			}
			// 精确查找某个时间的CPUMessage信息
			// hq.append("from ").append(table).append(" where date=:date");
			// 查询符合某个时间格式的CPUMessage信息，既可以查询某个时间段的信息
			hq.append("from ").append(table).append(" where date like :date");
			Query query = session.createQuery(hq.toString());
			query.setString("date", date + "%");
			list = query.list();
			for (OSMessage osMessage : list) {
				osMessage.setId(osMessage.getId());
				session.delete(osMessage);
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
	public OSMessage findNew(String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<OSMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1OS.class.getName();
				break;
			case "lsq":
				table = User2OS.class.getName();
			default:
				break;
			}
			// 精确查找某个时间的CPUMessage信息
			// hq.append("from ").append(table).append(" where date=:date");
			// 查询符合某个时间格式的CPUMessage信息，既可以查询某个时间段的信息
			hq.append("from ").append(table);
			Query query = session.createQuery(hq.toString());
			list = query.list();
			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();

		} finally {
			HerbinateSessionFactory.closeSession();
		}
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(list.size() - 1);
		}

	}

}
