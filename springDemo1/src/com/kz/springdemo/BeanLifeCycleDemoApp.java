package com.kz.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// load cfg file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		
		// retrive beans from container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//call method on bean
		System.out.println(theCoach.getDailyWorkout());

		// closing context
		context.close();
	}

}
