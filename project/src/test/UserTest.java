package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import model.User;

public class UserTest {
	
	User u = new User("testUsername","testPassword");
	@Test
	public void userSaveReadTest() {
		u.save();
		User u2 = new User();
		u2.setUsername("testUsername");
		u2.setPassword("");
		u2 = u2.read();
		assertEquals(u.getUsername(),u2.getUsername());
		assertEquals(u.getPassword(),u2.getPassword());
		System.out.println(u.getPassword()+" "+u2.getPassword());
	}
	
	@Test
	public void userUpdateTest() {
		User u3 = new User("testUsername", "AnotherPassword");
		u3.update();
		u = u.read();
		System.out.println(u.getPassword()+" "+u3.getPassword());
		assertEquals(u.getPassword(),"AnotherPassword");
		
	}
	
	@Test
	public void userDeleteTest() {
		u.delete();
		assertNull(u.read());
	}
}
