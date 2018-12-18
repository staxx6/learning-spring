package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;

	public BaseballCoach(FortuneService theFourtuneService) {
		fortuneService = theFourtuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice -- STUPID SLOW ECLIPSE";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
