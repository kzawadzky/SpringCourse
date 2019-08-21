package com.kz.springdemo;

public class BaseballCoach implements Coach {

	//define private field for dependency (for fortuneService)
	private FortuneService fortuneService;
	
	// define a constructor for injection
	public BaseballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout () {
		return "Spend 30 min on batting practice";
	}

	@Override
	public String getDailyFortune() {
	
		// use the fortuneService to get fortune
		return fortuneService.getFortune();
	}
}
