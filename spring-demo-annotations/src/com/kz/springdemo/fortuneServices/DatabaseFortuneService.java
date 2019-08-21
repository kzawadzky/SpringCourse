package com.kz.springdemo.fortuneServices;

import org.springframework.stereotype.Component;

import com.kz.springdemo.interfaces.FortuneService;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return null;
	}

}
