package com.jsp.projectm2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Projectm2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projectm2Application.class, args);
	}
    @Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
