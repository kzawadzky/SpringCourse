package com.kz.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		
	}

	@Override
	public String getDailyWorkout() {
		
		return "Start running motherfcker! *angry stare*";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//add an init method
	
	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: starting up");
	}
	
	// add destroy method
	
	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach: destroying shit");
	}
	

}













