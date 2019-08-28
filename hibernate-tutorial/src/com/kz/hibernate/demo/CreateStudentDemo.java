package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create a student obj
			System.out.println("Creating student obj.");

			Student tempStudent = new Student("Paul", "Wall", "wallpall@gmail.com");

			// start transaction
			session.beginTransaction();

			// save the obj
			System.out.println("Saving the student...");

			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} finally {
			factory.close();
		}

	}

}
