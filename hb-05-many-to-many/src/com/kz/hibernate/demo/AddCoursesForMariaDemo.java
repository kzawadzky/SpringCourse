package com.kz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kz.hibernate.demo.entity.Course;
import com.kz.hibernate.demo.entity.Instructor;
import com.kz.hibernate.demo.entity.InstructorDetail;
import com.kz.hibernate.demo.entity.Review;
import com.kz.hibernate.demo.entity.Student;

public class AddCoursesForMariaDemo {

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
			
			// get maria from db
			int studentId = 4;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("Loaded student: " + tempStudent);
			
			System.out.println("Student courses: " + tempStudent.getCourses());
			// create more courses
			Course tempCourse1 = new Course("Taking arrows to the knee like a pro");
			Course tempCourse2 = new Course("Cash register - freshest music maker");
			

			
			// add maria to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE.");

		} finally {
			session.close();
			factory.close();
		}

	}

}
