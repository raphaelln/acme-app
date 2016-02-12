package com.raphaelln.acme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AcmeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeAppApplication.class, args);
	}
}
