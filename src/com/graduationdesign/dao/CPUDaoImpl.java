package com.graduationdesign.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.graduationdesign.hibernatefactory.HerbinateSessionFactory;
import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.InterMessage;
import com.graduationdesign.user.User1CPU;
import com.graduationdesign.user.User1Inet;
import com.graduationdesign.user.User2CPU;
import com.graduationdesign.user.User2Inet;

public class CPUDaoImpl implements ICPUDao {

	@Override
	public void addCPUMessage(CPUMessage cpuMessage) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(cpuMessage);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			HerbinateSessionFactory.closeSession();
		}

	}

	// 这里有意义的操作应该是查询某个时间段内CPU数据的信息
	@Override
	public List<CPUMessage> find(String date, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<CPUMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1CPU.class.getName();
				break;
			case "lsq":
				table = User2CPU.class.getName();
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
	public void deleteCPUMessage(String date, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<CPUMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1CPU.class.getName();
				break;
			case "lsq":
				table = User2CPU.class.getName();
			default:
				break;
			}
			// 删除某个时间点的信息
			// hq.append("from ").append(table).append(" where date=:date");
			// 删除符合某个时间格式的CPUMessage信息，既可以查询某个时间段的信息
			hq.append("from ").append(table).append(" where date like :date");
			Query query = session.createQuery(hq.toString());
			query.setString("date", date + "%");
			list = query.list();
			for (CPUMessage cpuMessage : list) {
				cpuMessage.setId(cpuMessage.getId());
				session.delete(cpuMessage);
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
	public List<CPUMessage> findException(double critical, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<CPUMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1CPU.class.getName();
				break;
			case "lsq":
				table = User2CPU.class.getName();
			default:
				break;
			}
			hq.append("from ").append(table).append(" where countPercent >=").append(critical);
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
	public CPUMessage findNew(String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<CPUMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			StringBuilder hq2 = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1CPU.class.getName();
				break;
			case "lsq":
				table = User2CPU.class.getName();
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
		return list.get(0);

	}

}
