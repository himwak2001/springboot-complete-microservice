package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // enable feign client related functionality inside welcome microservice
public class WelcomeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(WelcomeServiceApplication.class, args);
	}

}
