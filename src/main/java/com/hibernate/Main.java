package com.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.cfg.HibernateConfiguration;
import com.hibernate.model.Employee;

public class Main {

	public static void main(String[] args) {
		Employee vikas = new Employee("Rakesh", "Male", 44000);
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
//		session.persist(vikas);
//		tx.commit();

		Employee employee = session.load(Employee.class, 14);
		System.out.println(employee);
	}

}
