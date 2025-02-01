package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Employee;

public class Main {

	public static void main(String[] args) {
		Employee vikas = new Employee("Vansh", "Male", 44000);
//		Configuration cfg = new Configuration().configure("hibernate.cfgg.xml");
//		SessionFactory sf = cfg.buildSessionFactory();
//		SessionFactory sf = new Configuration().configure("hibernate.cfgg.xml").buildSessionFactory();
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfgg.xml").build();
		Metadata  meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.buildSessionFactory();

		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(vikas);
		tx.commit();
	}

}
