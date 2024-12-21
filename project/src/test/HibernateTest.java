
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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import main.HibernateUtil;
import main.User;

@Entity
@Table(name = "TEST_T")
class TestDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String word;

	public TestDB() {

	}

	public TestDB(String word) {
		this.word = word;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}

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
		if (session != null)
			session.close();
		System.out.println("Session closed\n");
	}

	@Test
	public void hibernateInsertTest2() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();

			User[] u = new User[26];
			for (int i = 0; i < 26; i++) {
				String username = "user" + ((Integer)i).toString();
				String password = "pass" + ((Integer) i).toString();
				u[i] = new User(username, password);
				session.persist(u[i]);
			}
			session.flush();
			List<User> users = session.createQuery("from User u", User.class).list();
			users.forEach(s -> System.out.println(s.getUsername() + " " + s.getPassword()));
			session.getTransaction().commit();
		}
	}

	@Test
	public void hibernateInsertTest3() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			TestDB t = new TestDB("prova");
			session.persist(t);
			session.getTransaction().commit();
		}
	}

	@Test
	public void hibernateRemoveTest() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();

			List<TestDB> t = session.createQuery("from TestDB", TestDB.class).list();
			for (TestDB testDB : t) {
				System.out.println("id: " + testDB.getId() + " word: " + testDB.getWord());
				session.remove(testDB);
			}
			session.getTransaction().commit();
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		if (HibernateUtil.getSessionFactory() != null) {
			HibernateUtil.getSessionFactory().close();
			System.out.println("SessionFactory destroyed");
		}
	}
}
