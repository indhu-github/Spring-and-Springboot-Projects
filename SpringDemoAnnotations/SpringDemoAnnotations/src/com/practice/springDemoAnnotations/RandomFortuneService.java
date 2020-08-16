package com.practice.springDemoAnnotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	private String[] data= {
			"Beware",
			"Keep smiling",
			"Good luck"
	};
	private Random random=new Random();
	
	@Override
	public String getFortune() {
		//pick a random string from the array
		int index=random.nextInt(data.length);
		return data[index];
	}

}
