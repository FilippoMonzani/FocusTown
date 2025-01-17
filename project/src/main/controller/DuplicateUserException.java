package main.controller;

import main.model.User;

/**
 * The {@code DuplicateUserException} class represents a runtime exception 
 * that is thrown when an attempt is made to add a duplicate {@code User} object.
 * <p>
 * This exception provides constructors to specify the user causing the exception, 
 * an error message, or the underlying cause.
 * </p>
 */
public class DuplicateUserException extends RuntimeException {
	
	/**
     * The {@code User} object associated with the exception.
     */
	private User user;
	
	/**
     * Constructs a {@code DuplicateUserException} with the specified {@code User}.
     *
     * @param u the {@code User} causing the exception
     */
	public DuplicateUserException(User u) {
		this.user = u;
	}
	
	/**
     * Constructs a {@code DuplicateUserException} with no detail message or cause.
     */
	public DuplicateUserException() {
		super();
	}
	
	/**
     * Constructs a {@code DuplicateUserException} with the specified detail message, cause,
     * suppression enabled or disabled, and writable stack trace enabled or disabled.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     * @param enableSuppression whether suppression is enabled or disabled
     * @param writableStackTrace whether the stack trace should be writable
     */
	public DuplicateUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	   /**
     * Constructs a {@code DuplicateUserException} with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
	public DuplicateUserException(String message, Throwable cause) {
		super(message, cause);
	}
	
	  /**
     * Constructs a {@code DuplicateUserException} with the specified detail message.
     *
     * @param message the detail message
     */
	public DuplicateUserException(String message) {
		super(message);
	}
	
	/**
     * Constructs a {@code DuplicateUserException} with the specified cause.
     *
     * @param cause the cause of the exception
     */
	public DuplicateUserException(Throwable cause) {
		super(cause);
	}
}
