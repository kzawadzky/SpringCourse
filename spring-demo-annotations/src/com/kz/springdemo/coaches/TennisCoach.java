package com.kz.springdemo.coaches;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kz.springdemo.interfaces.Coach;
import com.kz.springdemo.interfaces.FortuneService;

@Component

public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: Post construct method");
	}
	
	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("TennisCoach: Starting predestroying methods - cleanup");
	}
	

	public TennisCoach() {
		System.out.println("TENISCOACH - default constructor");
	}
	
	/*
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.println("TENISCOACH - setterMethod"); fortuneService =
	 * theFortuneService; }
	 */

	/*
	 * @Autowired public TennisCoach(FortuneService theFortuneService) {
	 * this.fortuneService = theFortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Smack with that backhand 100 times.";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
