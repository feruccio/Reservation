package com.haurylenka.projects.reservation.interfaces;

import com.haurylenka.projects.reservation.beans.User;
import com.haurylenka.projects.reservation.exceptions.UserDAOException;

public interface UserDAO {
	
	User getUser(String login, String password) throws UserDAOException;

}
