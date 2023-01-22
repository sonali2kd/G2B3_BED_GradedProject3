package com.greatlearning.tta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TicketTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackerApplication.class, args);
	}

}