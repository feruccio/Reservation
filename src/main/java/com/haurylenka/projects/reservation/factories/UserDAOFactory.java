package com.haurylenka.projects.reservation.factories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.haurylenka.projects.reservation.exceptions.ReservationException;
import com.haurylenka.projects.reservation.interfaces.UserDAO;

public class UserDAOFactory {
	
	private static final String PROP_FILE_NAME = "config.properties";
	private static final String IMPL_NAME_KEY = "UserDAOImpl";
	private static UserDAO IMPLEMENTATION;
	
	private UserDAOFactory() {}
	
	public static UserDAO getUserDAOImpl() {
		try {
			if (IMPLEMENTATION == null) {
				String implName = getImplName();
				Class<?> clazz = Class.forName(implName);
				IMPLEMENTATION = (UserDAO) clazz.newInstance();
			}
			return IMPLEMENTATION;
		} catch (Exception e) {
			throw new ReservationException(
					"Unable to get a UserDAOImpl instance", e);
		}
	}
	
	private static String getImplName() throws IOException {
		InputStream stream = null;
		try {
			Properties prop = new Properties();
			stream = 
					UserDAOFactory.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME);
			if (stream != null) {
				prop.load(stream);
				return prop.getProperty(IMPL_NAME_KEY);
			} else {
				throw new FileNotFoundException(
						"Unable to find the " + PROP_FILE_NAME + " file");
			}
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}

}
