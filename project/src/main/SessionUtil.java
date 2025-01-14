package main;

import org.hibernate.Session;

/**
 * Utility class for managing Hibernate sessions.
 * <p>
 * Provides methods to start and end sessions with proper transaction management.
 * </p>
 */
public class SessionUtil {
	
	  /**
     * Starts a new Hibernate session and begins a transaction.
     * 
     * @return A {@link Session} object with an active transaction.
     */
	public static Session startSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		return session;
	}
	
	 /**
     * Ends the given Hibernate session by committing the transaction and closing the session.
     * 
     * @param session The {@link Session} to be ended.
     *                If the session is null, this method does nothing.
     */
	public static void endSession(Session session) {
		session.getTransaction().commit();
		if (session != null)
			session.close();
	}
}
