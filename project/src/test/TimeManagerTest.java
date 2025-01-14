package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.TimeManager;

public class TimeManagerTest {

	
	@Test
	public void tickTest() {
		int seconds = 3600;
		TimeManager t = new TimeManager(seconds);
		t.tick();
		assertEquals(t.toSeconds(),seconds-1);
	}
	
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
	
	@Test
	public void setToZeroTest() {
		TimeManager t = new TimeManager(10);
		t.setToZero();
		assertTrue(t.isZero());
	}
	
	@Test
	public void isZeroTestFail() {
		TimeManager tSeconds = new TimeManager(1);
		TimeManager tMinutes = new TimeManager(60);
		TimeManager tHours = new TimeManager(3600);
		assertFalse(tSeconds.isZero());
		assertFalse(tMinutes.isZero());
		assertFalse(tHours.isZero());
		
	}
	@Test
	public void toStringTest() {
		int var = 10;
		TimeManager t = new TimeManager(var*60*60+var*60+var);
		assertTrue(t.toString().equals("10:10:10"));
	}
	
	
}
