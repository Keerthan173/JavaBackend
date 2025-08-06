package com.keer.hiber.util;

import org.hibernate.SessionFactory;
//SessionFactory: Core Hibernate interface used to create Session objects to interact with the DB.
import org.hibernate.cfg.Configuration;
//Configuration: Used to configure Hibernate and build the SessionFactory.

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	// A static instance to ensure only one SessionFactory is created for the entire application.
	
	static {
	//A static block: Executes once when the class is loaded.
	//Ensures the setup happens only once.
		try {
			if(sessionFactory==null) {	// Safety check to ensure sessionFactory is not already initialized.
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				// new Configuration() → creates a configuration object.
				// .configure("hibernate.cfg.xml") → loads Hibernate settings from the XML file.
				// .buildSessionFactory() → builds the actual SessionFactory.
			}
		}
		catch (Exception e) {
			throw new RuntimeException("Error in creating session factory:"+e.getMessage());
		}
	}
	
	// Provides a public static method to access the singleton SessionFactory.
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
