package com.klef.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StateManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StateManagementApplication.class, args);
		System.out.println("State Management Service is running!");
	}

}
