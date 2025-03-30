package com.app.controller;

import com.app.entity.Greet;
import com.app.service.GreetServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/greet", produces = {MediaType.APPLICATION_JSON_VALUE})
@RefreshScope
public class GreetController {
    private static final Logger logger = LoggerFactory.getLogger(GreetController.class);

    @Autowired
    private GreetServiceImplementation greetServiceImplementation;

    @GetMapping
    public String greetPeople(@RequestParam(value = "name") String name){
        return "Hi, " + name;
    }

    @PostMapping("/add")
    public Greet addGreet(@RequestBody Greet newGreet){
        return greetServiceImplementation.addGreet(newGreet);
    }

    @GetMapping("/list")
    public List<Greet> getGreetList(){
        return greetServiceImplementation.getGreetList();
    }

    @GetMapping("/get-greet/{id}")
    public Greet getGreetBasedOnId(@RequestHeader("greet-welcome-correlation-id") String correlationId, @PathVariable Integer id){
        logger.debug("greet-welcome-correlation-id found: {}", correlationId);
        return greetServiceImplementation.getGreetById(id);
    }
}
