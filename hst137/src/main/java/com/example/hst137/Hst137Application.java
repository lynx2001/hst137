package com.example.hst137;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hst137Application {

	public static void main(String[] args) {
		SpringApplication.run(Hst137Application.class, args);
	}

}
