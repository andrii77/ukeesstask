package com.ukeesstask.codingspa;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CodingspaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingspaApplication.class, args);
	}
}
