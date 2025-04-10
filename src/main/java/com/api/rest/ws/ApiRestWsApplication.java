package com.api.rest.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.api.rest.ws")
@SpringBootApplication
public class ApiRestWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestWsApplication.class, args);
	}

}
