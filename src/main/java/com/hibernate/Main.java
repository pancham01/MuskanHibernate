package com.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.cfg.HibernateConfiguration;
import com.hibernate.model.Address;
import com.hibernate.model.Employee;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Address ad1 = new Address();
		ad1.setCity("Noida");
		ad1.setState("UP");
		Employee vikas = new Employee("Ashish", "Male", 44000);

		vikas.setAddress(ad1);
		ad1.setEmployee(vikas);
		
		
		session.persist(vikas);
//		session.persist(ad1);
		tx.commit();

//		Employee employee = session.get(Employee.class, 1);
//		System.out.println(employee);
//		System.out.println(employee.getAddress());
//
//		Address address = session.get(Address.class, 1);
//		System.out.println(address);
//		System.out.println(address.getEmployee());
	}

}
