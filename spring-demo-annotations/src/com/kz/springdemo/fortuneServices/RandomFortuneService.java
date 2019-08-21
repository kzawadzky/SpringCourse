package com.kz.springdemo.fortuneServices;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.kz.springdemo.interfaces.FortuneService;

@Component
public class RandomFortuneService implements FortuneService {

	//create array of strings
	private String[] data = {
			"Good luck!",
			"Normal luck...",
			"Bad AF luck :( "
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		//pick a random string from array
		int index = myRandom.nextInt(data.length);
		String randomizedFortune = data[index];
		return randomizedFortune;
	}

}
