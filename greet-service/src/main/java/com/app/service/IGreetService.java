package com.app.service;

import com.app.entity.Greet;

import java.util.List;
import java.util.Optional;

public interface IGreetService {
    // method to add a greet
    public Greet addGreet(Greet newGreet);

    // method to return list of greet
    public List<Greet> getGreetList();

    // method to get greet by id
    public Greet getGreetById(Integer id);
}
