package com.app.controller;

import com.app.dto.GreetDto;
import com.app.entity.Welcome;
import com.app.service.implementation.WelcomeServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/welcome")
@RefreshScope
public class WelcomeController {
    @Value("${welcome-name}")
    private String name;

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

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

    @GetMapping("/greet-info/{id}")
    public GreetDto getGreetInfo(@RequestHeader("greet-welcome-correlation-id") String correlationId, @PathVariable Integer id){
        logger.debug("greet-welcome-correlation-id found: {}", correlationId);
        return welcomeServiceImplementation.getGreetInfo(id, correlationId);
    }
}
