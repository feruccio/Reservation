package com.haurylenka.projects.reservation.exceptions;

public class UserDAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserDAOException() {
		super();
	}

	public UserDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDAOException(String message) {
		super(message);
	}

	public UserDAOException(Throwable cause) {
		super(cause);
	}

}
