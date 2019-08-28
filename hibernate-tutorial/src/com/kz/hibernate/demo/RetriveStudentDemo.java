package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Student;

public class RetriveStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

			// start transaction
			session.beginTransaction();

			// save the obj
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("DONE. Student id: " + tempStudent.getId());
			
			//Retriving student
				// getting new session
				session = factory.getCurrentSession();
				session.beginTransaction();
			
				// retriving student getid
				System.out.println("\nGetting student with id: " + tempStudent.getId());
				Student myStudent = session.get(Student.class, tempStudent.getId());
				
				System.out.println("get complete: "+ myStudent);
			
				// commit transaction
				session.getTransaction().commit();
				
				System.out.println("DONE");
			
			

		} finally {
			factory.close();
		}

	}

}
