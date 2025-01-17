package main.model;

/**
 * Custom exception thrown when a user enters the wrong password.
 */
public class WrongPasswordException extends Exception {
	private User user;
	
	 /**
     * Constructs a new WrongPasswordException for the specified user.
     * 
     * @param u The user who provided the wrong password.
     */
	public WrongPasswordException(User u) {
		this.user = u;
	}
	
	public User getUser() {
		return user;
	}
}
