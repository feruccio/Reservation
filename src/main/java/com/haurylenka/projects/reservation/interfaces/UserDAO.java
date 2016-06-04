package com.haurylenka.projects.reservation.interfaces;

import com.haurylenka.projects.reservation.beans.User;

public interface UserDAO {
	
	User getUser(String login, String password);

}
