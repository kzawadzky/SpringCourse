package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId=1;

			//Retriving student
				// getting new session
				session = factory.getCurrentSession();
				session.beginTransaction();
				
				System.out.println("\nGetting student with id: " + studentId);
				Student myStudent = session.get(Student.class, studentId);	
				
				System.out.println("Updating student: "+ myStudent);
				
				myStudent.setFirstName("Scooby");
			
			// commit transaction
				session.getTransaction().commit();
				
				System.out.println("DONE");
				
			// mass update
				
				session = factory.getCurrentSession();
				session.beginTransaction();
				
				//updating email for all students
				System.out.println("Updating email for all students");
				
				session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
				
				
				session.getTransaction().commit();
			
			

		} finally {
			factory.close();
		}

	}

}
