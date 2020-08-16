package com.practice.springDemoAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
				
				//retrieve bean from spring container
				Coach theCoach=context.getBean("tennisCoach",Coach.class);
				
				//call methods on the bean
				System.out.println(theCoach.getDailyWorkout());
				
				//call method to get the daily fortune
				System.out.println(theCoach.getDailyFortune());
				
				//close the context
				context.close();

	}

}
