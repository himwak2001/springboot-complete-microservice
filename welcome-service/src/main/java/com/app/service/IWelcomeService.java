package com.app.service;

import com.app.entity.Welcome;

import java.util.List;

public interface IWelcomeService {
    // method to add welcome details
    public Welcome addWelcome(Welcome welcome);

    // method to get lst of welcomes
    public List<Welcome> getWelcomeList();
}
