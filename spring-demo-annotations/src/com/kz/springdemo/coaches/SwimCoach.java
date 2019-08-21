package com.kz.springdemo.coaches;

import org.springframework.beans.factory.annotation.Value;

import com.kz.springdemo.interfaces.Coach;
import com.kz.springdemo.interfaces.FortuneService;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	@Value("${coach.email}")
	private String email;
	
	@Value("${coach.team}")
	private String team;
	
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}	

}
