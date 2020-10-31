package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Student;
import com.nt.factory.HibernateUtil;

public class Test2 {

	public static void main(String[] args) {
		HibernateUtil util=new HibernateUtil();
		Session ses=util.getSession();
		Student st=new Student();
		boolean flag=false;
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
			st=ses.get(Student.class, 1);
			if(st!=null) {
				System.out.println("Record is there");
				ses.delete(st);
				flag=true;
			}
			else {
				System.out.println("Record is not there");
			}
				
			
			
		}
		catch (Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Data Deleted");
			}
			else {
				if(tx!=null) {
					tx.rollback();
					System.out.println("Data Not Deleted");
				}
		}
			
		}
		
		
	}

}
