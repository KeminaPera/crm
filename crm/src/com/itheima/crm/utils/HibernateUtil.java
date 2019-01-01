package com.itheima.crm.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * <p>
 * Title: HibernateUtil
 * </p>
 * <p>
 * Description:session宸ュ叿绫�
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 浼犳櫤.鐕曢潚
 * @date 2016骞�2鏈�2鏃�
 * @version 1.0
 */
public class HibernateUtil {

	// 浼氳瘽宸ュ巶锛屼互鍗曚緥鏂瑰紡绠＄悊
	private static SessionFactory sessionFactory;

	// ThreadLocal瀛樺偍session
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();


	// 浠ュ崟渚嬫柟寮忕鐞唖essionFactory
	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException("鍒濆鍖栦細璇濆伐鍘傚け璐ワ紒");
		}

	}
	//寰楀埌涓�涓崟渚嬬殑浼氳瘽宸ュ巶
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	//鑾峰彇涓�涓柊session
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	//鑾峰彇褰撳墠涓庣嚎绋嬬粦瀹氱殑session锛屽鏋滆幏鍙栦笉鍒板垯鍒涘缓涓�涓柊session骞朵笌褰撳墠绾跨▼缁戝畾
//	public static Session getCurrentSession() throws HibernateException {
//		//鑾峰彇褰撳墠绾跨▼缁戝畾鐨剆ession
//		Session s = (Session) session.get();
//		if (s == null) {
//			//鍒涘缓涓�涓柊session
//			s = sessionFactory.openSession();
//			//鏂皊ession骞朵笌褰撳墠绾跨▼缁戝畾
//			session.set(s);
//		}
//		return s;
//	}
 
	public static Session getCurrentSession() throws HibernateException {
		return sessionFactory.getCurrentSession(); 
	}
	//鍏抽棴褰撳墠绾跨▼缁戝畾鐨剆ession
//	public static void closeSession() throws HibernateException {
//		//鑾峰彇褰撳墠绾跨▼缁戝畾鐨剆ession
//		Session s = (Session) session.get();
//		if (s != null){
//			//鍏抽棴session
//			s.close(); 
//		}
//		session.set(null);
//	}
	
	public static void closeSession() throws HibernateException {
		sessionFactory.getCurrentSession().close();
	}


}
