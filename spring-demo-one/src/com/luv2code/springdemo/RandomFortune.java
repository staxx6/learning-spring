package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortune implements FortuneService {

    private String[] array = {"first", "second", "third"};
    
    private Random rand = new Random();

    @Override
    public String getFortune() {
        return array[rand.nextInt(array.length)]; // 0-2 the 3 is exclusively
    }
}