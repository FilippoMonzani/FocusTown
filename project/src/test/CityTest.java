package test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;

import main.TimeManager;
import model.Building;
import model.City;
import model.User;

public class CityTest {
	
	City city = new City();
	User user = new User("Test","testPassword");
	
	@Test
	public void addBuildingTest() {
		TimeManager time = new TimeManager(7200);
		user.save();
		city.loadBuildings(user);
		city.addBuilding(time, "informatica", user);
		Building b = city.getBuildings().get(0);
		assertEquals(b.getOwner().getPassword(),"testPassword");
		assertEquals(b.getDuration(), Duration.ofSeconds(time.toSeconds()));
		assertEquals(b.getOwner().getUsername(),"Test");
		assertEquals(b.getSubject(),"informatica");
	}
}
