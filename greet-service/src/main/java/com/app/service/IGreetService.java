package com.app.service;

import com.app.entity.Greet;

import java.util.List;

public interface IGreetService {
    // method to add a greet
    public Greet addGreet(Greet newGreet);

    // method to return list of greet
    public List<Greet> getGreetList();
}
