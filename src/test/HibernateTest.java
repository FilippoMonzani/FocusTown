package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import main.HibernateUtil;
import main.UserDB;

public class HibernateTest {
	
//	private static SessionFactory sessionFactory;
	private Session session;
	
//	@BeforeClass
//    public static void setup() {
//        sessionFactory = HibernateUtil.getSessionFactory();
//        System.out.println("SessionFactory created");
//    }
	
	@Before
    public void openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Session created");
    }
     
    @After
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }  

	@Test
	public void hibernateInsertTest() {

		UserDB u1 = new UserDB("Sergio", "password");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			System.out.println("transizione iniziata");
			session.persist(u1);
			session.flush();
			System.out.println("utente salvato");
			UserDB u2 = session.find(UserDB.class, u1.getId());
			System.out.println("Query svolta");
			System.out.println("id: "+u1.getId()+" username: "+u1.getUsername()+" password: "+u1.getPassword());
			System.out.println("id: "+u2.getId()+" username: "+u2.getUsername()+" password: "+u2.getPassword());
			assertEquals(u2.getId(), u1.getId());
			assertEquals(u2.getPassword(), u1.getPassword());
			assertEquals(u2.getUsername(), u1.getUsername());
			session.getTransaction().commit();
		}
	}
	
	@Test
	public void hibernateInsertTest2 () {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			UserDB[] u = new UserDB[26];
			for(int i = 0; i<26; i++) {
				String password = ((Integer)i).toString();
				u[i] = new UserDB("Sergio",password);
				session.persist(u[i]);
			}
			session.flush();
			List<UserDB> users = session.createQuery("from UserDB u", UserDB.class).list();
			users.forEach(s->System.out.println(s.getUsername()+" "+ s.getPassword()));
			session.getTransaction().commit();
		}
		
	}
	
	   @AfterClass
	    public static void tearDown() throws Exception {
		   if ( HibernateUtil.getSessionFactory() != null ) {
			  HibernateUtil.getSessionFactory().close();
			  System.out.println("SessionFactory destroyed");
		   }
	    }
}

