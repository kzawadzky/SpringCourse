package com.kz.springdemo.mainApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kz.springdemo.interfaces.Coach;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load spring cfg
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		// retrive bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		// call methods
		boolean result = (theCoach == alphaCoach);
		System.out.println("Pointing to the same obj: " + result);
		System.out.println("Memory location for theCoach: " + theCoach);
		System.out.println("Memory location for alphaCoach: "+ alphaCoach);
		// close context
		context.close();
	}

}
