package com.haurylenka.projects.reservation.impls;

import java.io.IOException;
import java.util.List;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.haurylenka.projects.reservation.beans.Customer;
import com.haurylenka.projects.reservation.beans.FareFamily;
import com.haurylenka.projects.reservation.beans.ResComponent;
import com.haurylenka.projects.reservation.beans.Reservation;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.CustomerHome;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.CustomerRemote;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.FareFamilyHome;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.FareFamilyRemote;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.ReservationCompHome;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.ReservationCompRemote;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.ReservationHome;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.ReservationRemote;
import com.haurylenka.projects.reservation.exceptions.ReservationDAOException;
import com.haurylenka.projects.reservation.interfaces.ReservationDAO;
import com.haurylenka.projects.reservation.utils.ReservationUtil;

public class JNDIReservationDAOImpl implements ReservationDAO {

	@Override
	public Reservation getReservation(String code) throws ReservationDAOException {
		try {
			InitialContext initCtx = ReservationUtil.getInitialContext();
			Object resCtx = initCtx.lookup("ReservationSv");
			ReservationHome resCtxChecked = 
					(ReservationHome) PortableRemoteObject.narrow(
							resCtx, ReservationHome.class);
			ReservationRemote rr = resCtxChecked.create();
			return rr.getReservation(code);
		} catch (NamingException | IOException | CreateException e) {
			throw new ReservationDAOException(
					"An error occurred while retrieving a reservation", e);
		}
	}

	@Override
	public List<ResComponent> getResComponents(
			String code, String componentTypeCode) throws ReservationDAOException {
		try {
			InitialContext initCtx = ReservationUtil.getInitialContext();
			Object resCtx = initCtx.lookup("ReservationCompSv");
			ReservationCompHome resCtxChecked = 
					(ReservationCompHome) PortableRemoteObject.narrow(
							resCtx, ReservationCompHome.class);
			ReservationCompRemote rr = resCtxChecked.create();
			return rr.getResComponents(code, componentTypeCode);
		} catch (NamingException | IOException | CreateException e) {
			throw new ReservationDAOException(
					"An error occurred while retrieving reservation components", e);
		}
	}

	@Override
	public Customer getCustomer(String code) throws ReservationDAOException {
		try {
			InitialContext initCtx = ReservationUtil.getInitialContext();
			Object custCtx = initCtx.lookup("CustomerSv");
			CustomerHome custCtxChecked = 
					(CustomerHome) PortableRemoteObject.narrow(
							custCtx, CustomerHome.class);
			CustomerRemote cr = custCtxChecked.create();
			return cr.getCustomer(code);
		} catch (NamingException | IOException | CreateException e) {
			throw new ReservationDAOException(
					"An error occurred while retrieving a customer", e);
		}
	}

	@Override
	public FareFamily getFareFamily(String code) throws ReservationDAOException {
		try {
			InitialContext initCtx = ReservationUtil.getInitialContext();
			Object ffCtx = initCtx.lookup("FareFamilySv");
			FareFamilyHome ffCtxChecked = 
					(FareFamilyHome) PortableRemoteObject.narrow(
							ffCtx, FareFamilyHome.class);
			FareFamilyRemote ffr = ffCtxChecked.create();
			return ffr.getFareFamily(code);
		} catch (NamingException | IOException | CreateException e) {
			throw new ReservationDAOException(
					"An error occurred while retrieving a fare family", e);
		}
	}

}
