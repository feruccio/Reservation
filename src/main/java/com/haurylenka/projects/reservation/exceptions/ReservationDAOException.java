package com.haurylenka.projects.reservation.exceptions;

public class ReservationDAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public ReservationDAOException() {
		super();
	}

	public ReservationDAOException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReservationDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReservationDAOException(String message) {
		super(message);
	}

	public ReservationDAOException(Throwable cause) {
		super(cause);
	}

}
