package com.kz.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// querry students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query last name = Doe
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			// display the students
			System.out.println("\nShowing students where last name = doe");
			displayStudents(theStudents);
			
			//query students last name doe OR first name Duffy
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName ='Daffy'").getResultList();
			System.out.println("\n\nShowing students where last name = doe OR first name = Daffy");
			displayStudents(theStudents);
			
			
			// query students where email ends with gmail.com
			System.out.println("\n\nQuery students where email ends with gmail.com");
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
