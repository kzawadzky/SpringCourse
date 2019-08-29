package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Instructor;
import com.kz.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
//GAMEPLAN:

//			// create obj
//			Instructor tempInstructor = new Instructor("Krzysztof", "Zawadzki", "zet@gmail.com");
//
//			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/gfhyjytefxcv", "gaming");
//
//			// associate the objts
//			tempInstructor.setInstructorDetail(tempInstructorDetail);


			// create obj

			Instructor tempInstructor = new Instructor("Paula", "Zawadzka", "pz@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/cascdf", "numbers");

			// associate the objts
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			
			
			
			// start transaction
			session.beginTransaction();

			// save instructor this will aslo save the details (bcs of cascade)
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} finally {
			factory.close();
		}

	}

}
