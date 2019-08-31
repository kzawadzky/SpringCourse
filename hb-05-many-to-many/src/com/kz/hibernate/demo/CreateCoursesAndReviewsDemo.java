package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Course;
import com.kz.hibernate.demo.entity.Instructor;
import com.kz.hibernate.demo.entity.InstructorDetail;
import com.kz.hibernate.demo.entity.Review;
import com.kz.hibernate.demo.entity.Student;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
//GAMEPLAN:
			
			// start transaction
			session.beginTransaction();

			
			//create a course
			Course tempCourse = new Course("QuakeIII arena rocket jumping");
			
			
			System.out.println("kzDEBUG: Saving the course...");
			session.save(tempCourse);
			System.out.println("kzDEBUG: Save complete. " + tempCourse);
			
			//creating students:
			
			Student tempStudent1 = new Student("Robert", "Trebor", "rt@gmail.com");
			Student tempStudent2 = new Student("Maria", "Zet", "mz@gmail.com");
			
			//add students to the course
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//saving the students
			System.out.println("kzDEBUG: Saving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("kzDEBUG: Students saved: " + tempStudent1 + " " + tempStudent2);
			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} finally {
			session.close();
			factory.close();
		}

	}

}
