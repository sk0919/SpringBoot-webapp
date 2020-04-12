package com.support.supportapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.support.supportapis.entity")
@EnableJpaRepositories("com.support.supportapis.repository")
@SpringBootApplication
public class SupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportApplication.class, args);
	}
}
