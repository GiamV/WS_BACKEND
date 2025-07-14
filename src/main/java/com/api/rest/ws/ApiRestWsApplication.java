package com.api.rest.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan("com.api.rest.ws")
@SpringBootApplication
@EnableScheduling
public class ApiRestWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestWsApplication.class, args);
	}

}
