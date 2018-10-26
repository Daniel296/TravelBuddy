package com.travel.buddy.coreproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CoreProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreProjectApplication.class, args);
	}
}
