package com.nt.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		ses=HibernateUtil.getSession();
		Employee emp=new Employee();
		//List Property Initialization
		List friendsList=new ArrayList();
		friendsList.add("Venkatesh");friendsList.add("Venkatesh");friendsList.add("Naveen");
		//Set Property Initialization
		Set hobbiesSet=new HashSet<String>();
		hobbiesSet.add("Playing Cricket");hobbiesSet.add("Listening to Music");
		//Map Property Initialization
		Map<String,Long> accounts=new HashMap<String,Long>();
		accounts.put("SBI", 1111111111l);
		accounts.put("CANARA", 2222222222l);
		emp.setName("Pavan J");emp.setFriends(friendsList);emp.setHobbies(hobbiesSet);
		emp.setBankAccounts(accounts);
		boolean flag=true;
		try{
			tx=ses.beginTransaction();
			ses.save(emp);
		}
		catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Data Inserted");
			}
			else {
				tx.rollback();
				System.out.println("Data Not Inserted");
			}
		}
		
		
	}

}
