package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import main.model.User;

/**
 * Unit tests for the {@link User} class, verifying user-related database operations.
 * <p>This test class contains unit tests to validate the behavior of the methods 
 * in the {@link User} class, including saving, reading, updating, and deleting users 
 * in the database.</p>
 */
public class UserTest {
	
	User u = new User("userTest","testPassword");
	
	 /**
     * Test for saving and reading a user from the database.
     * <p>This test verifies that the {@link User#save()} and {@link User#read()} 
     * methods correctly persist and retrieve the user data from the database.</p>
     */

	@Test
	public void userSaveReadTest() {
		u.save();
		User u2 = new User();
		u2.setUsername("userTest");
		u2.setPassword("");
		u2 = u2.read();
		assertEquals(u.getUsername(),u2.getUsername());
		assertEquals(u.getPassword(),u2.getPassword());
		System.out.println(u.getPassword()+" "+u2.getPassword());
	}
	
	/**
     * Test for updating a user in the database.
     * <p>This test ensures that the {@link User#update()} method correctly updates 
     * the user's information in the database.</p>
     */
	@Test
	public void userUpdateTest() {
		User u3 = new User("userTest", "AnotherPassword");
		u3.update();
		u = u.read();
		System.out.println(u.getPassword()+" "+u3.getPassword());
		assertEquals(u.getPassword(),"AnotherPassword");
		
	}
	
	/**
     * Test for deleting a user from the database.
     * <p>This test verifies that the {@link User#delete()} method correctly deletes 
     * the user from the database, and that the {@link User#read()} method returns null 
     * after deletion.</p>
     */
	@Test
	public void userDeleteTest() {
		u.delete();
		assertNull(u.read());
	}
}
