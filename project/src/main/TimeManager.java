package main;

/**
 * Utility class for managing and manipulating time in hours, minutes, and seconds.
 * <p>
 * Provides methods to convert time between seconds, minutes, and hours,
 * as well as utility functions such as ticking down time and checking if time is zero.
 * </p>
 */
public class TimeManager {

	int hours = 0;
	int minutes = 0;
	int seconds = 0;

	/**
     * Default constructor initializes time to 00:00:00.
     */
	public TimeManager() {
		super();
	}

	 /**
     * Constructor initializes time using the given number of seconds.
     * 
     * @param seconds The total seconds to initialize the time.
     */
	public TimeManager(int seconds) {
		this.ofSeconds(seconds);
	}

	 /**
     * Adds the specified seconds to the current time.
     * 
     * @param seconds The number of seconds to add.
     */
	public void ofSeconds(int seconds) {
		seconds += this.seconds;
		int m = 0;
		while (seconds >= 60) {
			m++;
			seconds -= 60;
		}
		this.ofMinutes(m);
		this.seconds = seconds;
	}
	
	 /**
     * Adds the specified minutes to the current time.
     * 
     * @param minutes The number of minutes to add.
     */
	public void ofMinutes(int minutes) {
		minutes += this.minutes;
		int h = 0;
		while (minutes >= 60) {
			h++;
			minutes -= 60;
		}
		this.ofHours(h);
		this.minutes = minutes;
	}

	 /**
     * Adds the specified hours to the current time.
     * Caps the total hours at 24.
     * 
     * @param hours The number of hours to add.
     */
	public void ofHours(int hours) {
		hours += this.hours;
		if (hours > 24) {
			hours = 24;
		}
		this.hours = hours;
	}

	 /**
     * Converts the current time to total minutes.
     * 
     * @return The total time in minutes.
     */
	public int toMinutes() {
		return hours * 60 + minutes;
	}

	/**
     * Converts the current time to total seconds.
     * 
     * @return The total time in seconds.
     */
	public int toSeconds() {
		return hours * 60 * 60 + minutes * 60 + seconds;
	}
	
	/**
     * Returns the string representation of the time in HH:mm:ss format.
     * 
     * @return A formatted string representing the time.
     */
	public String toString() {
		String hourString;
		String minuteString;
		String secondString;
		if (hours < 10) {
			hourString = "0" + ((Integer) hours).toString();
		} else {
			hourString = ((Integer) hours).toString();
		}
		if (minutes < 10) {
			minuteString = "0" + ((Integer) minutes).toString();
		} else {
			minuteString = ((Integer) minutes).toString();
		}
		if (seconds < 10) {
			secondString = "0" + ((Integer) seconds).toString();
		}
		else {
			secondString = ((Integer) seconds).toString();
		}
		return hourString + ":" + minuteString + ":" + secondString;
	}

	 /**
     * Decreases the time by one second.
     * If the time reaches 00:00:00, it stops decrementing.
     */
	public void tick() {
		if (this.seconds == 0) {
			if (this.minutes == 0) {
				if (this.hours == 0) {
					return;
				}
				this.minutes = 60;
				hours--;
			}
			this.seconds = 60;
			minutes--;
		}
		seconds--;
	}
	
	 /**
     * Checks if the time is set to 00:00:00.
     * 
     * @return True if the time is zero, otherwise false.
     */
	public boolean isZero() {
		return (this.hours == 0 && this.minutes == 0 && this.seconds == 0);
	}
	
	 /**
     * Resets the time to 00:00:00.
     */
	public void setToZero() {
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
	}

	// Getters
	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}


	public int getSeconds() {
		return seconds;
	}

}
