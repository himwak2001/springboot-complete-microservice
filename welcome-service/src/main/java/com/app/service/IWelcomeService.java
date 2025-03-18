package com.app.service;

import com.app.dto.GreetDto;
import com.app.entity.Welcome;

import java.util.List;

public interface IWelcomeService {
    // method to add welcome details
    public Welcome addWelcome(Welcome welcome);

    // method to get lst of welcomes
    public List<Welcome> getWelcomeList();

    // method to fetch greet details
    public GreetDto getGreetInfo(Integer Id);
}
