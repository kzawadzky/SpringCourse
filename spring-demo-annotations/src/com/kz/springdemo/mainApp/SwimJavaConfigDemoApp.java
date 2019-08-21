package com.kz.springdemo.mainApp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kz.springdemo.coaches.SwimCoach;
import com.kz.springdemo.configs.SportConfig;
import com.kz.springdemo.interfaces.Coach;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring cfg file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// call the bean from container
		// you either change the bean for a swim coach, or you cast on the swimcoach in the method, found out the hard way. casting is fancy tho.
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		// call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		System.out.println("Coach email: " + ((SwimCoach) theCoach).getEmail());
		System.out.println("Coach team: " + ((SwimCoach) theCoach).getTeam());
		
		
		//close context
		context.close();
	}

}
