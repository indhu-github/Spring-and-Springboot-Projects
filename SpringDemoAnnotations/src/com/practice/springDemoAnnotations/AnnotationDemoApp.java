package com.practice.springDemoAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnotationDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
				ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
				
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
