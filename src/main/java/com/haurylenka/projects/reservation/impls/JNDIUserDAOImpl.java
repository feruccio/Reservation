package com.haurylenka.projects.reservation.impls;

import java.io.IOException;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.haurylenka.projects.reservation.beans.User;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.UserHome;
import com.haurylenka.projects.reservation.ejbBeans.interfaces.UserRemote;
import com.haurylenka.projects.reservation.exceptions.UserDAOException;
import com.haurylenka.projects.reservation.interfaces.UserDAO;
import com.haurylenka.projects.reservation.utils.ReservationUtil;

public class JNDIUserDAOImpl implements UserDAO {

	@Override
	public User getUser(String login, String password) throws UserDAOException {
		try {
			InitialContext initCtx = ReservationUtil.getInitialContext();
			Object userCtx = initCtx.lookup("UserSv");
			UserHome userCtxChecked = (UserHome) PortableRemoteObject.narrow(
					userCtx, UserHome.class);
			UserRemote ur = userCtxChecked.create();
			return ur.getUser(login, password);
		} catch (NamingException | IOException | CreateException e) {
			throw new UserDAOException(
					"An error occurred while retrieving a user", e);
		}
	}

}
