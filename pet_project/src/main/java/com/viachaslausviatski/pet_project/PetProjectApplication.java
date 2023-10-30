package com.viachaslausviatski.pet_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.viachaslausviatski")
public class PetProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetProjectApplication.class, args);
	}

}
