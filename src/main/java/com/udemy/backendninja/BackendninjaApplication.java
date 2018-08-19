package com.udemy.backendninja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.udemy.backendninja.entity")
public class BackendninjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendninjaApplication.class, args);
	}
}
