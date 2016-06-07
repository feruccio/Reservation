package com.haurylenka.projects.reservation.interfaces;

import java.util.List;

import com.haurylenka.projects.reservation.beans.Customer;
import com.haurylenka.projects.reservation.beans.FareFamily;
import com.haurylenka.projects.reservation.beans.ResComponent;
import com.haurylenka.projects.reservation.beans.Reservation;
import com.haurylenka.projects.reservation.exceptions.ReservationDAOException;

public interface ReservationDAO {

	Reservation getReservation(String code) throws ReservationDAOException;
	
	List<ResComponent> getResComponents(String code, String componentTypeCode) 
			throws ReservationDAOException;
	
	Customer getCustomer(String code) throws ReservationDAOException;
	
	FareFamily getFareFamily(String code) throws ReservationDAOException;
	
}
