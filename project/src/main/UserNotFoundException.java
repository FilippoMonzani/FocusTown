package main;

import model.User;

public class UserNotFoundException extends Exception {
	private User user;
	
	public UserNotFoundException(User u) {
		this.user = u;
	}
}
