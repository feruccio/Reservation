package com.haurylenka.projects.reservation.interfaces;

import com.haurylenka.projects.reservation.beans.Reservation;
import com.haurylenka.projects.reservation.exceptions.ReservationDAOException;

public interface ReservationDAO {

	Reservation getReaservation(String login) throws ReservationDAOException;
	
}
