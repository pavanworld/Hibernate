package com.nt.factory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private static Session ses;
	
	static { 
		System.out.println("HibernateUtil Static Block");
		Configuration conf=new Configuration();
		try {
			conf.configure("com/nt/cfgs/hibernate.cfg.xml");
			factory=conf.buildSessionFactory();
			ses=factory.openSession();
		}
		catch (HibernateException he) {
			System.out.println("HibernateUtil Catch Block");
			he.printStackTrace();
		}
		System.out.println("HibernateUtil Static Block End");
		
		
	}
	public static Session getSession() {
		if(ses!=null)
			return ses;
		else 
			return null;
		
	}
	
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
		System.out.println("Session is Closed");
		
	}
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
		
		System.out.println("SessionFactory is Closed");
		
	}
	

}
