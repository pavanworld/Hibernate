package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Student;
import com.nt.factory.HibernateUtil;

public class Test1 {

	public static void main(String[] args) {
		HibernateUtil util=new HibernateUtil();
		Session ses=util.getSession();
		Student st=new Student();
		boolean flag=false;
		st.setId(9);
		Transaction tx=ses.beginTransaction();
		try{
			ses.delete(st);
			flag=true;
		}
		catch (Exception e) {
			System.out.println("Record Deleted");
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Data Deleted");
			}
			else {
				tx.rollback();
				System.out.println("Data Not Deleted");
		}
			
		}
		
		
	}

}
