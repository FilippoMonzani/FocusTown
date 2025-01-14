package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.junit.Test;

import main.FocusApp;
import main.HibernateUtil;
import model.Building;
import model.City;
import model.User;

public class BuildingTest {

	User u = new User("Test","test");
	Building b = new Building(Duration.ofSeconds(7200), "programmazione web", u);
	// private static final Logger logger =
	// LogManager.getLogger(BuildingTest.class);
	@Test
	public void buildingInsertTest() {
		City c = new City();
		u.save();
		b.save();
		c.loadBuildings(u);
		Building b2 = c.getBuildings().get(0);
		System.out.println("Updated id: " + b.getId());
		assertEquals(b.getId(),b2.getId());
		assertEquals(b.getOwner().getPassword(),b2.getOwner().getPassword());
	}
}
