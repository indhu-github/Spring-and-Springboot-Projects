package com.practice.springDemoAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
				
				//retrieve bean from spring container
				SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
				
				//call methods on the bean
				System.out.println(theCoach.getDailyWorkout());
				
				//call method to get the daily fortune
				System.out.println(theCoach.getDailyFortune());
				
				//call our new swim coach methods..has the props values injected
				System.out.println("Email: "+theCoach.getEmail());
				System.out.println("Team: "+theCoach.getTeam());
				
				//close the context
				context.close();

	}

}
