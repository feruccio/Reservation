package com.haurylenka.projects.reservation.impls;

import com.haurylenka.projects.reservation.beans.User;
import com.haurylenka.projects.reservation.exceptions.UserDAOException;
import com.haurylenka.projects.reservation.interfaces.UserDAO;

public class MemoryUserDAOImpl implements UserDAO {
	
	private static final String LOGIN = "user";
	private static final String PASSWORD = "user";

	@Override
	public User getUser(String login, String password) throws UserDAOException {
		User user = null;
		if (LOGIN.equals(login) && PASSWORD.equals(password)) {
			user = new User(login);
		}
		return user;
	}

}
