package main;

import model.User;

public class DuplicateUserException extends RuntimeException {

	private User user;
	
	public DuplicateUserException(User u) {
		this.user = u;
	}
	
	public DuplicateUserException() {
		super();
	}

	public DuplicateUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicateUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateUserException(String message) {
		super(message);
	}

	public DuplicateUserException(Throwable cause) {
		super(cause);
	}
}
