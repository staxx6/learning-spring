package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on server is: " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String sayWorkout() {
        return "Doing stuff here moreee Nice stuff";
    }

    @GetMapping("/fortune")
    public String sayFortune() {
        return "kek";
    }

    @GetMapping("/fortune2")
    public String sayFortune2() {
        return "ke k2 " + coachName;
    }
}
