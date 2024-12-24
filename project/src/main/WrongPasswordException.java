package main;

import model.User;

public class WrongPasswordException extends Exception {
	private User user;
	
	public WrongPasswordException(User u) {
		this.user = u;
	}
}
