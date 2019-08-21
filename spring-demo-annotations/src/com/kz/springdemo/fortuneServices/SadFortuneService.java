package com.kz.springdemo.fortuneServices;

import com.kz.springdemo.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today must be monday";
	}

}
