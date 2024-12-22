package main;

import model.User;

public class WrongPasswordException extends RuntimeException {
	private User user;
	
	public WrongPasswordException(User u) {
		this.user = u;
	}
}
