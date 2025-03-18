package com.app.service.implementation;

import com.app.dto.GreetDto;
import com.app.entity.Welcome;
import com.app.repository.IWelcomeRepository;
import com.app.service.IWelcomeService;
import com.app.service.client.GreetFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WelcomeServiceImplementation implements IWelcomeService {
    @Autowired
    private IWelcomeRepository welcomeRepository;

    @Autowired
    private GreetFeignClient feignClient;

    @Override
    public Welcome addWelcome(Welcome welcome) {
        return welcomeRepository.save(welcome);
    }

    @Override
    public List<Welcome> getWelcomeList() {
        return welcomeRepository.findAll();
    }

    @Override
    public GreetDto getGreetInfo(Integer id) {
        return feignClient.getGreetBasedOnId(id);
    }
}
