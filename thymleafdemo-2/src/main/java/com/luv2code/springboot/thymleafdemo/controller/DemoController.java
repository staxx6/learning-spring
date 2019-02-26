package com.luv2code.springboot.thymleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("date", new java.util.Date());
        return "helloworld";
    }
}
