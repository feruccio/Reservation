package com.haurylenka.projects.reservation.factories;

import com.haurylenka.projects.reservation.exceptions.ReservationException;
import com.haurylenka.projects.reservation.interfaces.ReservationDAO;
import com.haurylenka.projects.reservation.utils.ReservationUtil;

public class ReservationDAOFactory {

	private static final String IMPL_NAME_KEY = "ReservationDAOImpl";
	private static ReservationDAO IMPLEMENTATION;
	
	private ReservationDAOFactory() {}
	
	public static ReservationDAO getResrvationDAO() {
		try {
			if (IMPLEMENTATION == null) {
				String implName = 
						ReservationUtil.getProperty(IMPL_NAME_KEY);
				Class<?> clazz = Class.forName(implName);
				IMPLEMENTATION = (ReservationDAO) clazz.newInstance();
			}
			return IMPLEMENTATION;
		} catch (Exception e) {
			throw new ReservationException(
					"Unable to get a UserDAOImpl instance", e);
		}
	}
	
}
