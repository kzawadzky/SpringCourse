package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create a student obj
			System.out.println("Creating 3 student obj.");

			Student tempStudent1 = new Student("Krzysztof", "Zet", "zet@gmail.com");
			Student tempStudent2 = new Student("John", "Doe", "jon@gmail.com");
			Student tempStudent3 = new Student("Mary", "Public", "marry@gmail.com");

			// start transaction
			session.beginTransaction();

			// save the obj
			System.out.println("Saving the student...");

			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} finally {
			factory.close();
		}

	}

}
