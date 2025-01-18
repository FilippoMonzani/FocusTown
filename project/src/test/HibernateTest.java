
package test;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private final static Logger logger = LogManager.getLogger(HibernateTest.class);

	/**
     * Opens a Hibernate session before each test.
     * 
     * <p>This method is called before each test method to initialize a Hibernate session 
     * for database operations.</p>
     */
	@Before
	public void openSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		logger.log(Level.INFO, "Session created");
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
		logger.log(Level.INFO, "Session closed");
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
				logger.log(Level.INFO, String.format("id: %d, word: %s", testDB.getId(), testDB.getWord()));
				session.remove(testDB);
			}
			session.getTransaction().commit();
		}

}