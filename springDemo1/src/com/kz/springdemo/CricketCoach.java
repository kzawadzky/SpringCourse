package com.kz.springdemo;

public class CricketCoach implements Coach {
	private String emailAddress;
	private String team;
	private FortuneService fortuneService;
	
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket: innside setter method. email.");
		this.emailAddress = emailAddress;
	}

	
	public String getEmailAddress() {
		return emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public FortuneService getFortuneService() {
		return fortuneService;
	}


	public void setTeam(String team) {
		System.out.println("Cricket: innside setter method. team.");
		this.team = team;
	}


	public CricketCoach() {
		System.out.println("Cricket: innside no arg constr.");
	}
	
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket: innside setter method. fortuneService");
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
