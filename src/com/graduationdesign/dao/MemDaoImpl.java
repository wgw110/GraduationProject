package com.graduationdesign.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.graduationdesign.hibernatefactory.HerbinateSessionFactory;
import com.graduationdesign.po.MemoryMessage;
import com.graduationdesign.user.User1Mem;
import com.graduationdesign.user.User2Mem;

public class MemDaoImpl implements IMemDao {

	@Override
	public void addMemMessage(MemoryMessage memMessage) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(memMessage);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			HerbinateSessionFactory.closeSession();
		}

	}

	@Override
	public List<MemoryMessage> find(String date, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<MemoryMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1Mem.class.getName();
				break;
			case "lsq":
				table = User2Mem.class.getName();
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
		return list;
	}

	@Override
	public void deleteMemMessage(String date, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<MemoryMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1Mem.class.getName();
				break;
			case "lsq":
				table = User2Mem.class.getName();
			default:
				break;
			}
			hq.append("from ").append(table).append(" where date like :date");
			Query query = session.createQuery(hq.toString());
			query.setString("date", date + "%");
			list = query.list();
			for (MemoryMessage memMessage : list) {
				memMessage.setId(memMessage.getId());
				session.delete(memMessage);
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
	public List<MemoryMessage> findException(double critical, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<MemoryMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1Mem.class.getName();
				break;
			case "lsq":
				table = User2Mem.class.getName();
			default:
				break;
			}
			hq.append("from ").append(table).append(" where usedPercent >=").append(critical);
			Query query = session.createQuery(hq.toString());
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
	public MemoryMessage findNew(String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<MemoryMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			StringBuilder hq2 = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1Mem.class.getName();
				break;
			case "lsq":
				table = User2Mem.class.getName();
			default:
				break;
			}
			hq.append("from ").append(table);
			Query query = session.createQuery(hq.toString());
			list = query.list();
			System.out.println("list size:" + list.size());
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
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(list.size() - 1);
		}
	}

}
