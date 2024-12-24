package model;

import main.UserNotFoundException;
import main.WrongPasswordException;

public class AuthenticationService {
	
	/**
	 * Throws an error if authentication fails
	 * @param u User to authentication
	 * @param password Password to check
	 * @return The supplied user
	 * @throws UserNotFoundException If the user is not in the database
	 * @throws WrongPasswordException If the password does not match
	 */
	public User login(User u, String password) throws UserNotFoundException, WrongPasswordException {
		u = u.read(); // read returns null if username is not in db
		if (u == null) {
			throw new UserNotFoundException(u);
		}
		
		if (!u.getPassword().equals(password)) {
			throw new WrongPasswordException(u);
		}
		return u;
	}
}
