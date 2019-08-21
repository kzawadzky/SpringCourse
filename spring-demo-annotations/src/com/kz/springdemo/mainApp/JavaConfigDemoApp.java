package com.kz.springdemo.mainApp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kz.springdemo.configs.SportConfigWithComponentScan;
import com.kz.springdemo.interfaces.Coach;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring cfg file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfigWithComponentScan.class);
		
		// call the bean from container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//close context
		context.close();
	}

}
