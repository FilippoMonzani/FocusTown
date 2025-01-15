package test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;

import main.TimeManager;
import model.Building;
import model.City;
import model.User;

/**
 * Unit test for handling City operations, particularly for adding a building.
 * 
 * <p>This class tests the correct functionality of adding a building to the city, 
 * ensuring that the building is properly associated with the user, the correct 
 * duration is set, and the subject is accurately stored.</p>
 */
public class CityTest {
	
	City city = new City();
	User user = new User("cityTest","testPassword");
	
	/**
     * Test that verifies the addition of a building to the city.
     * 
     * <p>This test saves a user, loads the buildings for that user, 
     * and adds a new building to the city. The test then verifies that the 
     * building's owner, duration, subject, and username are correctly assigned.</p>
     */
	@Test
	public void addBuildingTest() {
		TimeManager time = new TimeManager(7200);
		
        // Save user and load buildings
		user.save();
		city.loadBuildings(user);
		
        // Add new building to city
		city.addBuilding(time, "informatica", user);
		
        // Retrieve the first building from the city
		Building b = city.getBuildings().get(0);
		
        // Verify the building's details
		assertEquals(b.getOwner().getPassword(),"testPassword");
		assertEquals(b.getDuration(), Duration.ofSeconds(time.toSeconds()));
		assertEquals(b.getOwner().getUsername(),"cityTest");
		assertEquals(b.getSubject(),"informatica");
	}
}
