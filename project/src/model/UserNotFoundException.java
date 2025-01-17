package model;

/**
 * Custom exception thrown when a specified user is not found.
 */
public class UserNotFoundException extends Exception {
	private User user;
	
	/**
     * Constructs a new UserNotFoundException with the specified user.
     * 
     * @param u The user that was not found.
     */
	public UserNotFoundException(User u) {
		this.user = u;
	}
	
	public User getUser() {
		return user;
	}
}
