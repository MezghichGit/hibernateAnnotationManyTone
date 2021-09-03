package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	public static final SessionFactory sessionFactory;
	public static ServiceRegistry serviceRegistry;
	static {
	try {
	// Initialize the hibernate configuration.
	Configuration configuration = new Configuration().configure();
	// Build a service registry fron the properties of the configuration –
	// This is new in Hibernate 4 !
	serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	configuration.getProperties()).build();
	// Build the SessionFactory !
	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	} catch (Throwable ex) {
	// Log the exception.
	System.err.println("Initial SessionFactory creation failed." + ex);
	throw new ExceptionInInitializerError(ex);
	}
	}
	
	
	
	public static SessionFactory getSessionFactory() {
	return sessionFactory;
	}
}