package com.app.controller;

import com.app.entity.Welcome;
import com.app.service.implementation.WelcomeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/welcome")
@RefreshScope
public class WelcomeController {
    @Value("${welcome-name}")
    private String name;

    @Autowired
    private WelcomeServiceImplementation welcomeServiceImplementation;

    @GetMapping
    public String getWelcomeMessage(){
        return "Hello "+name+", Welcome to the Spring Boot with Keycloak";
    }

    @PostMapping("/add")
    public Welcome addWelcome(@RequestBody Welcome welcome){
        return welcomeServiceImplementation.addWelcome(welcome);
    }

    @GetMapping("/list")
    public List<Welcome> getWelcomeList(){
        return welcomeServiceImplementation.getWelcomeList();
    }
}
