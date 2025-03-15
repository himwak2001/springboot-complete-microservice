package com.app.service;

import com.app.entity.Greet;
import com.app.repository.IGreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetServiceImplementation implements IGreetService{
    @Autowired
    private IGreetRepository greetRepository;

    @Override
    public Greet addGreet(Greet newGreet) {
        return greetRepository.save(newGreet);
    }

    @Override
    public List<Greet> getGreetList() {
        return greetRepository.findAll();
    }

    @Override
    public Greet getGreetById(Integer id) {
        return greetRepository.findById(id).get();
    }
}
