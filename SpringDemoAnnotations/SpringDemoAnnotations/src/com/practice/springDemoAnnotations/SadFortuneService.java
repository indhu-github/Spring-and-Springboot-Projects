package com.practice.springDemoAnnotations;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Sad FortuneService Class";
	}

}
