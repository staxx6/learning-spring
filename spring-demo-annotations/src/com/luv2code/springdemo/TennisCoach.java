package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
//@Scope("singleton")
// @Scope("prototype")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // @Autowired
    // public TennisCoach(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

    public TennisCoach() {
        System.out.println("TennisCoach default constructor");
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("TennisCoach: inside of doMyStartupStuff()");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("TennisCoach: inside of doMyCleanupStuff()");
    }

    @Override
    public String getDailyWorkout() {
        return "Do some stuff what a tennis player would do";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // Another injection type
    // @Autowired
    // public void setFortuneService(FortuneService fortuneService) {
    //     System.out.println("Setter here used");
    //     this.fortuneService = fortuneService;
    // }

    // Another injection type
    // @Autowired
    // public void doSomeCrazyStuff(FortuneService fortuneService) {
    //     System.out.println("doSomeCrazyStuff here used");
    //     this.fortuneService = fortuneService;
    // }
}
