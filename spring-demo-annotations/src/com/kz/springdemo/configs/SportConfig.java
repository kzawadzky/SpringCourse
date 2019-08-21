package com.kz.springdemo.configs;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.kz.springdemo.coaches.SwimCoach;
import com.kz.springdemo.fortuneServices.SadFortuneService;
import com.kz.springdemo.interfaces.Coach;
import com.kz.springdemo.interfaces.FortuneService;

@Configuration
// @ComponentScan("com.kz.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	@Bean
	@PostConstruct
	public MyLoggerConfig logger() {
		return new MyLoggerConfig();
	}
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
		
		return mySwimCoach;
	}
	


}
