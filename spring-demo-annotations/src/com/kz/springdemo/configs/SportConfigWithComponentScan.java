package com.kz.springdemo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kz.springdemo.coaches.SwimCoach;
import com.kz.springdemo.fortuneServices.SadFortuneService;
import com.kz.springdemo.interfaces.Coach;
import com.kz.springdemo.interfaces.FortuneService;

@Configuration
@ComponentScan("com.kz.springdemo")
public class SportConfigWithComponentScan {
	
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
	@Bean
	public MyLoggerConfig logger() {
		return new MyLoggerConfig();
	}

}
