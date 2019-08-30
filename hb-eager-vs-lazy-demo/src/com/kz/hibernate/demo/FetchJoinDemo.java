package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.kz.hibernate.demo.entity.Course;
import com.kz.hibernate.demo.entity.Instructor;
import com.kz.hibernate.demo.entity.InstructorDetail;


public class FetchJoinDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
//GAMEPLAN:

			
			// start transaction
			session.beginTransaction();
			
			// HIBERNATE QUERY WITH HQL

			// get the instructor from db
			
			int theId = 1;
			
			Query <Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "were i.id=:theInstructorId", Instructor.class);

			//set parameter on query
					
					query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("kzDEBUG: Instructor: " + tempInstructor);
			

			
			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} finally {
			session.close();
			factory.close();
		}

	}

}
