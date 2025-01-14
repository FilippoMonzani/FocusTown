package model;

import main.UserNotFoundException;
import main.WrongPasswordException;

/**
 * Service class that handles user authentication.
 * <p>
 * This class provides a method to authenticate a user by checking their username and password.
 * If the authentication fails (either due to a non-existent user or incorrect password),
 * appropriate exceptions are thrown.
 * </p>
 */
public class AuthenticationService {
	
	 /**
     * Authenticates a user based on the supplied username and password.
     * <p>
     * This method retrieves the user from the database and checks if the provided password matches
     * the user's password. If the username is not found or the password is incorrect,
     * corresponding exceptions will be thrown.
     * </p>
     * 
     * @param u The user to authenticate (must contain the username).
     * @param password The password to check against the stored one.
     * @return The authenticated user.
     * @throws UserNotFoundException If the user does not exist in the database.
     * @throws WrongPasswordException If the provided password does not match the stored password.
     */
	public User login(User u, String password) throws UserNotFoundException, WrongPasswordException {
		u = u.read(); // read returns null if username is not in db
		if (u == null) {
			throw new UserNotFoundException(u);
		}
		
		if (!u.getPassword().equals(password)) {
			throw new WrongPasswordException(u);
		}
		return u; // Return the authenticated user
	}
}
