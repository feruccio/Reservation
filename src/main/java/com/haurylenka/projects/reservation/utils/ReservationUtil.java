package com.haurylenka.projects.reservation.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.haurylenka.projects.reservation.factories.UserDAOFactory;

public class ReservationUtil {

	private static final String PROP_FILE_NAME = "config.properties";
	
	private ReservationUtil() {}
	
	public static String getProperty(String target) 
			throws IOException {
		InputStream stream = null;
		try {
			Properties prop = new Properties();
			stream = 
					UserDAOFactory.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME);
			if (stream != null) {
				prop.load(stream);
				return prop.getProperty(target);
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
