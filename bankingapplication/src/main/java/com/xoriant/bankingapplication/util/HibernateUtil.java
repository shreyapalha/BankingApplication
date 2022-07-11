package com.xoriant.bankingapplication.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory = null;
	// SessionFactory object that i want to make a singlton object 

	private HibernateUtil() {
		
	}
	
	public static SessionFactory getSessionFactory() {
		
		if(factory ==null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
		
	}
	public static void main(String[] args) {
		getSessionFactory();
	}
	
	
	

}
