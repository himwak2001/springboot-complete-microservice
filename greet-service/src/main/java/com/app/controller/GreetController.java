package com.app.controller;

import com.app.entity.Greet;
import com.app.service.GreetServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greet")
@RefreshScope
public class GreetController {
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
}
