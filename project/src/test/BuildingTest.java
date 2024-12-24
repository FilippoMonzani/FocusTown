package test;

import java.time.Duration;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.junit.Test;

import main.HibernateUtil;
import model.Building;
import model.User;

public class BuildingTest {

	@Test
	public void BuildingInsertTest() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			System.out.println("Session created");
			session.beginTransaction();
			User u = new User("Giuseppe Psaila", "cbgfnsjg");
			session.persist(u);
			Building b = new Building(Duration.ofSeconds(7200), "programmazione web", u);
			session.persist(b);
			session.getTransaction().commit();
		}
	}
}
