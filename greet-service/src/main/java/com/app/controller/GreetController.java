package com.app.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
@RefreshScope
public class GreetController {

    @GetMapping
    public String greetPeople(@RequestParam(value = "name") String name){
        return "Hi, " + name;
    }
}
