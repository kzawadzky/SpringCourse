package com.kz.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	private FortuneService fortuneService;

	public FootballCoach() {

	}

	@Autowired public FootballCoach(@Qualifier("randomFortuneService")FortuneService theFortuneService) {
		
		this.fortuneService = theFortuneService; 
	}
	

	@Override
	public String getDailyWorkout() {

		return "Practice freekicks Beckham-style.";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
