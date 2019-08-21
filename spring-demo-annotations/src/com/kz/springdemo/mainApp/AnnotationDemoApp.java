package com.kz.springdemo.mainApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kz.springdemo.interfaces.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring cfg file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");
		
		// call the bean from container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//close context
		context.close();
	}

}
