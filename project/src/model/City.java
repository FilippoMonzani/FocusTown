// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package model;

import java.time.Duration;
import java.util.List;

import org.hibernate.Session;
import main.SessionUtil;

/************************************************************/
/**
 * Represents the collection of buildings belonging to a specific user.
 * 
 * <p>The buildings are stored in a transient list after the login phase, 
 * while the building objects themselves are persistent entities in the database. 
 * This class provides methods to add new buildings to the database and load existing 
 * buildings for a user.</p>
 * 
 * @author Sergio
 */
public class City {
	 /**
     * A transient list containing buildings associated with the user.
     */
	private List<Building> buildings;

	// public User user;

	 /**
     * Creates a new building with the specified characteristics, 
     * adds it to the transient list, and persists it in the database.
     * 
     * @param duration the duration required to construct the building
     * @param subject the subject that the user has worked on during the productivity session (e.g., "Law", "English")
     * @param owner the user who owns the building
     */
	public void addBuilding(Duration duration, String subject, User owner) {
		Building building = new Building(duration, subject, owner);
		Session session = SessionUtil.startSession();
		session.persist(building);
		buildings.add(building);
	}

	/**
     * Loads all buildings belonging to a specific user from the database
     * and adds them to the transient list. This method should be called 
     * after the login phase to initialize the city's building list.
     * 
     * @param user the owner of the buildings to be loaded
     */
	public void loadBuildings(User user) {
		Session session = SessionUtil.startSession();
		List<Building> retrievedBuildings = session.createQuery("from Building b where b.owner = :owner_username", Building.class).setParameter("owner_username", user.getUsername()).list();
		for (Building b : retrievedBuildings) {
			String password = session.createQuery("select u.password from app_user u where u.username = :owner_username", String.class).setParameter("owner_username", user.getUsername()).toString();
			b.getOwner().setPassword(password);
			buildings.add(b);
		}
		SessionUtil.endSession(session);
	}
	
	
}
