package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(SportConfig.class);

        Coach myCoach = context.getBean("tennisCoach", Coach.class);
        Coach otherCoach = context.getBean("gameCoach", Coach.class);

        System.out.println(myCoach.getDailyWorkout());
        System.out.println(otherCoach.getDailyWorkout());

        System.out.println(myCoach.getDailyFortune());

        context.close();
    }
}
