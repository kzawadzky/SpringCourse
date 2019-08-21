package com.kz.springdemo;

public class FootballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	public FootballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout () {
		return "Practice freekicks from 25 meters.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
