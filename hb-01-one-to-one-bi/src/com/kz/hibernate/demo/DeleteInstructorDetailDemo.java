package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Instructor;
import com.kz.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get the instructor detail
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
			
			
			// delete (cascade deletion)
			
			System.out.println("deleting objct: " + tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
		finally {
			session.close();
			
			factory.close();
		}

	}

}
