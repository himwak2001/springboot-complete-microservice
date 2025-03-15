package com.app.service.implementation;

import com.app.entity.Welcome;
import com.app.repository.IWelcomeRepository;
import com.app.service.IWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WelcomeServiceImplementation implements IWelcomeService {
    @Autowired
    private IWelcomeRepository welcomeRepository;

    @Override
    public Welcome addWelcome(Welcome welcome) {
        return welcomeRepository.save(welcome);
    }

    @Override
    public List<Welcome> getWelcomeList() {
        return welcomeRepository.findAll();
    }
}
