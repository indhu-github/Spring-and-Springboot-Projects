package com.practice.springDemoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	FortuneService fortuneService;
	
	//Define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach-Inside a default constructor");
	}
	
	/*
	//define a setter method
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("TennisCoach-Inside a setter method");
		this.fortuneService = fortuneService;
	}*/
	
	/*
	//define any method name
		@Autowired
		public void doSomeStuff(FortuneService fortuneService) {
			System.out.println("TennisCoach-Inside doSomeStuff method");
			this.fortuneService = fortuneService;
		}*/
		
	/*@Autowired //constructor injection
	public TennisCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}*/

	


	@Override
	public String getDailyWorkout() {
		return "In TennisCoach Class";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
