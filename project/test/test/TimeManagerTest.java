package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.controller.TimeManager;

/**
 * Unit tests for the {@link TimeManager} class, verifying time-related functionalities.
 * <p>This test class contains unit tests to validate the behavior of the methods 
 * in the {@link TimeManager} class, including time manipulation, conversion, and 
 * string representation of time.</p>
 */
public class TimeManagerTest {

	 /**
     * Test for the {@link TimeManager#tick()} method.
     * <p>This test ensures that the {@link TimeManager#tick()} method decreases 
     * the time by one second.</p>
     */
	@Test
	public void tickTest() {
		int seconds = 3600;
		TimeManager t = new TimeManager(seconds);
		t.tick();
		assertEquals(t.toSeconds(),seconds-1);
	}

	 /**
     * Test for the {@link TimeManager#ofSeconds(int)} method.
     * <p>This test verifies that the constructor correctly converts a given number 
     * of seconds into hours, minutes, and seconds.</p>
     */
	@Test
	public void ofSecondsTest () {
		int testVariable = 3; 
		int hours = testVariable;
		int minutes =  testVariable;
		int seconds = testVariable;
		TimeManager t = new TimeManager(seconds + minutes*60 + hours*60*60);
		assertEquals(hours, t.getHours());
		assertEquals(minutes, t.getMinutes());
		assertEquals(seconds, t.getSeconds());
	}
	
	/**
     * Test for the {@link TimeManager#setToZero()} method.
     * <p>This test ensures that the {@link TimeManager#setToZero()} method sets 
     * the time to zero and the {@link TimeManager#isZero()} method returns true.</p>
     */
	@Test
	public void setToZeroTest() {
		TimeManager t = new TimeManager(10);
		t.setToZero();
		assertTrue(t.isZero());
	}
	
	/**
     * Test for the {@link TimeManager#isZero()} method, verifying it returns 
     * false when time is not zero.
     * <p>This test checks the {@link TimeManager#isZero()} method with different 
     * time intervals (seconds, minutes, and hours) to ensure it behaves as expected.</p>
     */
	@Test
	public void isZeroTestFail() {
		TimeManager tSeconds = new TimeManager(1);
		TimeManager tMinutes = new TimeManager(60);
		TimeManager tHours = new TimeManager(3600);
		assertFalse(tSeconds.isZero());
		assertFalse(tMinutes.isZero());
		assertFalse(tHours.isZero());
		
	}
	
	/**
     * Test for the {@link TimeManager#toString()} method.
     * <p>This test ensures that the {@link TimeManager#toString()} method returns 
     * the correct time string in the format "HH:MM:SS".</p>
     */
	@Test
	public void toStringTest() {
		int var = 10;
		TimeManager t = new TimeManager(var*60*60+var*60+var);
		assertTrue(t.toString().equals("10:10:10"));
	}
	
	
}
