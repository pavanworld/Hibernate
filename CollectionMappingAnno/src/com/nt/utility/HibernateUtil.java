package com.nt.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	
	static {
		try {
			Configuration cfg=new Configuration();
			cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			factory=cfg.buildSessionFactory();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		} 
		
			
	}
	
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.getCurrentSession();
		return ses;
	}
			
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
		System.out.println("HibernateUtil.closeSession()");
	}
	
	public void closeSessionFactory() {
		if(factory!=null)
			factory.close();
		System.out.println("HibernateUtil.closeSessionFactory()");
	}

}
