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

/**
 * Unit test for handling Building objects.
 * 
 * <p>This class contains tests to verify the correct functionality of operations related
 * to managing Building instances, such as inserting a new building and loading a building 
 * from a city associated with a specific user.</p>
 */
public class BuildingTest {

	User u = new User("Test","test");
	Building b = new Building(Duration.ofSeconds(7200), "programmazione web", u);
	// private static final Logger logger =
	// LogManager.getLogger(BuildingTest.class);
	
	/**
     * Test that verifies the insertion of a Building object into the city.
     * 
     * <p>This test creates a new building, saves it to the database, 
     * loads the buildings associated with the user, and verifies that the inserted 
     * object has the correct ID and the associated owner has the same password 
     * as the saved object.</p>
     */
	@Test
	public void buildingInsertTest() {
		City c = new City();
		u.save();
		b.save();
		c.loadBuildings(u);
		Building b2 = c.getBuildings().get(0);
		
        // Print the updated ID of the building
		System.out.println("Updated id: " + b.getId());
		
        // Verify that the IDs and passwords match
		assertEquals(b.getId(),b2.getId());
		assertEquals(b.getOwner().getPassword(),b2.getOwner().getPassword());
	}
}
