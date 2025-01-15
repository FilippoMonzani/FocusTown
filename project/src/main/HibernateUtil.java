package main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Utility class for configuring and providing a Hibernate {@link SessionFactory}.
 * This class initializes a single {@code SessionFactory} instance for the application.
 */
public class HibernateUtil {
	// Singleton instance of the SessionFactory
	private static final SessionFactory sessionFactory;

	// Static initializer block to configure and build the SessionFactory
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
     * Provides the singleton instance of {@link SessionFactory}.
     * 
     * @return the {@link SessionFactory} instance
     */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/*
	 * public static void shutdown() { if (registry != null) {
	 * StandardServiceRegistryBuilder.destroy(registry); } }
	 */

}
