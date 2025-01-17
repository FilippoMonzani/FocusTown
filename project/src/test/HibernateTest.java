
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.logging.log4j.core.Logger;
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
import main.model.User;
import main.model.dbutil.HibernateUtil;

/**
 * Unit tests for performing Hibernate operations, including inserting and removing 
 * entries from the database using Hibernate ORM.
 * 
 * <p>This test class is used to test basic database operations with Hibernate 
 * such as persisting and removing entities. It tests the interaction with 
 * a test database and verifies that records can be inserted and removed 
 * properly from the database.</p>
 */
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

/**
 * Tests Hibernate persistence operations such as inserting and removing entities.
 * 
 * <p>This test class ensures the correct functionality of Hibernate's insert and remove 
 * operations. It uses a simple entity (`TestDB`) to insert data into the database and 
 * then remove it, verifying the session lifecycle and transaction handling.</p>
 */
public class HibernateTest {

	private Session session;

	/**
     * Opens a Hibernate session before each test.
     * 
     * <p>This method is called before each test method to initialize a Hibernate session 
     * for database operations.</p>
     */
	@Before
	public void openSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Session created");
	}

	/**
     * Closes the Hibernate session after each test.
     * 
     * <p>This method is called after each test method to close the Hibernate session 
     * and ensure proper cleanup of resources.</p>
     */
	@After
	public void closeSession() {
		if (session != null)
			session.close();
		System.out.println("Session closed\n");
	}

	 /**
     * Tests inserting data into the database using Hibernate.
     * 
     * <p>This test persists a series of `TestDB` entities into the database. It 
     * verifies that new entries can be inserted and the transaction is committed.</p>
     */
	@Test
	public void hibernateInsertTest() {
			session.beginTransaction();

			TestDB[] t = new TestDB[10];
			for (int i = 0; i < 10; i++) {
				String word = "prova" + ((Integer) i).toString();
				t[i] = new TestDB(word);
				session.persist(t[i]);
			}
			session.getTransaction().commit();
		}


	/**
     * Tests removing data from the database using Hibernate.
     * 
     * <p>This test retrieves all `TestDB` entities from the database, prints their 
     * details, and then removes them. It verifies that the delete operation is properly 
     * handled in a Hibernate session.</p>
     */
	@Test
	public void hibernateRemoveTest() {

			session.beginTransaction();

			List<TestDB> t = session.createQuery("from TestDB", TestDB.class).list();
			for (TestDB testDB : t) {
				System.out.println("id: " + testDB.getId() + " word: " + testDB.getWord());
				session.remove(testDB);
			}
			session.getTransaction().commit();
		}

	   /**
     * Cleans up the session factory after all tests are finished.
     * 
     * <p>This method is called after all tests have been run to close the Hibernate 
     * session factory and clean up resources.</p>
     * 
     * @throws Exception if any error occurs during the cleanup process
     */
	@AfterClass
	public static void tearDown() throws Exception {
		if (HibernateUtil.getSessionFactory() != null) {
			HibernateUtil.getSessionFactory().close();
			System.out.println("SessionFactory destroyed");
			//Logger logger = new Logger();
		}
	}
}