package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    Injection guidelines

        A general guideline, as recommended also by Spring (see "Constructor-based or setter-based DI" section) is following:

        For mandatory dependencies or when aiming for immutability, use Constructor injection
        For optional or changeable dependencies use setter injection
        Avoid field injection in most of the cases.

    Field injection Drawbacks
    The reasons why field injection is frowned upon are following:

        You cannot create immutable objects as with constructor injection
        Your classes have tight coupling with DI container and cannot be used outside of it
        Your classes cannot be instantiated (for example in unit tests) without reflection. You need the DI container to instantiate them, which is more like integration tests
        Your real dependencies are hidden from outside and are not reflected in your interface - constructors or methods
        It is really easy to have like 10 dependencies. If you were using constructor injection, having constructor with 10 arguments will signal that something is fishy. But you can add injected fields using field injection indefinitely. Having too many dependencies is a red flag that the class usually does more than one thing and it may be a violation of a Single Responsibility Principle.

        --> https://docs.spring.io/spring/docs/4.2.x/spring-framework-reference/html/beans.html
*/

/*
    In contrast to the other scopes, Spring does not manage the complete lifecycle of a
    prototype bean
*/


public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Coach myCoach = context.getBean("thatSillyCoach", Coach.class);
        Coach myCoach = context.getBean("tennisCoach", Coach.class);
        Coach otherCoach = context.getBean("gameCoach", Coach.class);

        System.out.println(myCoach.getDailyWorkout());
        System.out.println(otherCoach.getDailyWorkout());

        System.out.println(myCoach.getDailyFortune());

        context.close();
    }
}
