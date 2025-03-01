package com.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
@RefreshScope
public class WelcomeController {
    @Value("${welcome-name}")
    private String name;

    @GetMapping
    public String getWelcomeMessage(){
        return "Hello "+name+", Welcome to the Spring Boot with Keycloak";
    }
}
