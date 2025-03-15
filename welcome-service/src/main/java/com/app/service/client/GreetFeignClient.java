package com.app.service.client;

import com.app.dto.GreetDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "GREET-SERVICE")
public interface GreetFeignClient {

    @GetMapping("/api/get-greet/{id}")
    public GreetDto getGreetBasedOnId(@PathVariable Integer id);
}
