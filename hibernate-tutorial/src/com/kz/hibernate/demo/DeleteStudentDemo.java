package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// Deleting student
			// getting new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);

			/*
			 * System.out.println("Deleting student: " + myStudent);
			 * session.delete(myStudent);
			 */
			
			// alternate delete aproach
			
			session.createQuery("delete from Student where id=2").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE");

		} finally {
			factory.close();
		}

	}

}
