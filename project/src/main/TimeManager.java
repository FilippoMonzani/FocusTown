package main;

public class TimeManager {

	int hours = 0;
	int minutes = 0;
	int seconds = 0;

	public TimeManager(int seconds) {
		this.ofSeconds(seconds);
	}

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

	public void ofHours(int hours) {
		hours += this.hours;
		if (hours > 24) {
			hours = 24;
		}
		this.hours = hours;
	}

	public int toMinutes() {
		return hours * 60 + minutes;
	}

	public int toSeconds() {
		return hours * 60 * 60 + minutes * 60 + seconds;
	}
	
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

	public static int calculateHours(int h, int m) {
		int minutes;
		int hours;
		hours = h;
		minutes = m;
		while (minutes >= 60) {
			hours++;
			minutes -= 60;
		}
		if (hours > 24) {
			hours = 24;
		}
		return hours;
	}

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
	
	public boolean isZero() {
		return (this.hours == 0 && this.minutes == 0 && this.seconds == 0);
	}
}
