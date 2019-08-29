package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Instructor;
import com.kz.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get instructor by id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Found instructor: " + tempInstructor);

			// delete instructor

			if (tempInstructor != null) {

				System.out.println("Deleting instructor: " + tempInstructor);

				// this will also delete details obj, bcs of cascade!
				session.delete(tempInstructor);
			}

			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} finally {
			factory.close();
		}

	}

}
