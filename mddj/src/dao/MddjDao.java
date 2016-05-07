package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import po.DJPO;

public class MddjDao {

	public int dltData(int ID) {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		HashMap entry = (HashMap) session.get("DJPO", Integer.valueOf(ID));
		if (entry != null) {
			Transaction tran = session.beginTransaction();
			session.delete(entry);
			tran.commit();
		}
		session.close();
		sessionFactory.close();
		return 1;
	}

	public int addData(DJPO entry) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		entry.setDate(new java.sql.Date(new Date().getTime()));
		session.save("DJPO", entry);
		tran.commit();
		String hql = "from DJPO where bianhao='" + entry.getBianhao() + "'";
		Query query = session.createQuery(hql);
		List<HashMap> list = query.list();
		int result = (int) list.get(0).get("ID");
		session.close();
		sessionFactory.close();
		return result;
	}

	public int updateData(DJPO entry) {
		// 本来是想使用seesion的update方法的，但是由于hbm.xml文件定义的主键是自动增加的，更新出问题了。
		// 所以暂时用这个方法，但是更新后的数据会跑到最后去。
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update("DJPO", entry);
		tran.commit();
		session.close();
		sessionFactory.close();
		return 1;
	}

	public ArrayList<DJPO> query(DJPO entry) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		String hql = "from DJPO where";
		String str = (String) entry.getBianhao();
		if (str != null && !str.equals("")) {
			hql += " bianhao='" + str + "' and ";
		}
		str = (String) entry.getFawenzihao();
		if (str != null && !str.equals("")) {
			hql += " wenhao='" + str + "' and ";
		}
		str = (String) entry.getUnitSend();
		if (str != null && !str.equals("")) {
			hql += " unitSend='" + str + "' and ";
		}
		str = (String) entry.getUnitreceive();
		if (str != null && !str.equals("")) {
			hql += " unitreceive='" + str + "' and ";
		}
		str = (String) entry.getTitle();
		if (str != null && !str.equals("")) {
			hql += " title='" + str + "' and ";
		}
		if (entry.getDengji() != null && !entry.getDengji().equals("")) {
			hql += " dengji=" + entry.getDengji();
		} else {
			hql = hql.substring(0, hql.length() - 5);
		}
		System.out.println(hql);
		Query query = session.createQuery(hql);
		List<DJPO> list = query.list();
		ArrayList<DJPO> pos = new ArrayList<DJPO>();
		pos.addAll(list);
		session.close();
		sessionFactory.close();
		return pos;
	}

	public ArrayList<DJPO> stastic(String date, String category) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		String hql = "FROM DJPO ";
		boolean df = category != null && date.matches("[0-9]+");
		boolean cf = category != null && !category.equals("所有");
		if (df || cf) {
			hql += "WHERE ";
			if (df) {
				hql += "  date = '" + date + "' AND";
			}
			if (cf) {
				if (category.equals("收文")) {
					hql += " bianhao LIKE '%J%' OR bianhao LIKE '%Q%'";
				} else if (category.equals("发文")) {
					hql += " bianhao LIKE '%M%' OR bianhao LIKE '%B%'";
				}
			}else{
				hql = hql.substring(0, hql.length()-4);
			}
		}
		//System.out.println(hql);
		Query query = session.createQuery(hql);
		List<DJPO> list = query.list();
		ArrayList<DJPO> pos = new ArrayList<DJPO>();
		pos.addAll(list);
		session.close();
		sessionFactory.close();
		return pos;
	}
	
	public ArrayList<DJPO> getAllData() {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from DJPO");
		@SuppressWarnings("unchecked")
		List<DJPO> list = query.list();
		ArrayList<DJPO> pos = new ArrayList<DJPO>();
		pos.addAll(list);
		session.close();
		sessionFactory.close();
		return pos;
	}

//	public static void main(String[] args){
//		MddjDao dao = new MddjDao();
//		dao.getAllData();
//	}
}
