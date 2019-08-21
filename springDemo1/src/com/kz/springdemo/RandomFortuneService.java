package com.kz.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String [] data = {"Good luck", "Bad luck", "Normal state of luck"};
	
	private Random myRandom = new Random ();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String theFortune = data [index];
		return theFortune;
	}

}
