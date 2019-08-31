package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Course;
import com.kz.hibernate.demo.entity.Instructor;
import com.kz.hibernate.demo.entity.InstructorDetail;
import com.kz.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
//GAMEPLAN:
			
			// start transaction
			session.beginTransaction();

			
			//create a course
			Course tempCourse = new Course("QuakeIII arena rocket jumping");
			
			// add some reviews
			tempCourse.addReview(new Review("Good shit"));
			tempCourse.addReview(new Review("tldr"));
			tempCourse.addReview(new Review("doesnt work, killed myself"));
			tempCourse.addReview(new Review("-4/10"));
			
			
			// save the course (all reviews will be saved due to cascade)
			System.out.println("kzDEBUG: Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			
			session.save(tempCourse);
			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} finally {
			session.close();
			factory.close();
		}

	}

}
