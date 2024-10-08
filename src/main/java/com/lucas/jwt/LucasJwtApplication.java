package com.lucas.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LucasJwtApplication {
	public static void main(String[] args) {
		SpringApplication.run(LucasJwtApplication.class, args);
	}
}
