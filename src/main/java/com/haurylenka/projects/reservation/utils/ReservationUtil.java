package com.haurylenka.projects.reservation.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
	
	public static InitialContext getInitialContext() 
			throws IOException, NamingException {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, 
				"org.jboss.naming.NamingContextFactory");
		env.put(Context.URL_PKG_PREFIXES, 
				"org.jboss.naming:org.jnp.interfaces");
		String jndiUrl = getProperty("JNDI_URL");
		env.put(Context.PROVIDER_URL, jndiUrl);
		return new InitialContext(env);
	}
	
}
