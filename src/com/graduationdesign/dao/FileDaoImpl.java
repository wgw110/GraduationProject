package com.graduationdesign.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.graduationdesign.hibernatefactory.HerbinateSessionFactory;
import com.graduationdesign.po.FileMessage;
import com.graduationdesign.user.User1File;
import com.graduationdesign.user.User2File;

public class FileDaoImpl implements IFileDao {

	@Override
	public void addFileMessage(FileMessage fileMessage) {
		// TODO Auto-generated method stub
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(fileMessage);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			HerbinateSessionFactory.closeSession();
		}

	}

	@Override
	public List<FileMessage> find(String date, String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<FileMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1File.class.getName();
				break;
			case "lsq":
				table = User2File.class.getName();
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
	public void deleteFileMessage(String date, String prefix) {
		// TODO Auto-generated method stub
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<FileMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1File.class.getName();
				break;
			case "lsq":
				table = User2File.class.getName();
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
			for (FileMessage fileMessage : list) {
				fileMessage.setId(fileMessage.getId());
				session.delete(fileMessage);
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
	public List<FileMessage> findNew(String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<FileMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			StringBuilder hq2 = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1File.class.getName();
				break;
			case "lsq":
				table = User2File.class.getName();
			default:
				break;
			}
			// 精确查找某个时间的CPUMessage信息
			// hq.append("from ").append(table).append(" where date=:date");
			// 查询符合某个时间格式的CPUMessage信息，既可以查询某个时间段的信息
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

	@Override
	public List<FileMessage> findOver(String prefix) {
		Session session = HerbinateSessionFactory.getSession();
		Transaction transaction = null;
		List<FileMessage> list = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder hq = new StringBuilder();
			String table = null;
			switch (prefix) {
			case "wgw":
				table = User1File.class.getName();
				break;
			case "lsq":
				table = User2File.class.getName();
			default:
				break;
			}
			hq.append("from ").append(table).append(" where fileName like :fileSys").append(" and filePercent>=80");
			Query query2 = session.createQuery(hq.toString());
			query2.setString("fileSys", "%" + "C" + "%");
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
