package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class GameCoach implements Coach {

    public GameCoach() {
        System.out.println("In the no arg con of game coach");
    }

    @Override
    public String getDailyWorkout() {
        return "Easy peasy";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}