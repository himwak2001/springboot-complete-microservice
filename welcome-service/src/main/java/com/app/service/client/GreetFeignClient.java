package com.app.service.client;

import com.app.dto.GreetDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "GREET-SERVICE")
public interface GreetFeignClient {

    @GetMapping("/api/greet/get-greet/{id}")
    public GreetDto getGreetBasedOnId(@RequestHeader("greet-welcome-correlation-id") String correlationId, @PathVariable Integer id);
}
