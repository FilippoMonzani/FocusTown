package main;

import org.hibernate.Session;

public class SessionUtil {
	
	public static Session startSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		return session;
	}
	
	public static void endSession(Session session) {
		session.getTransaction().commit();
		if (session != null)
			session.close();
	}
}
