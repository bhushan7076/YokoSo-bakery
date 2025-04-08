package com.bakery.bakehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BakehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakehouseApplication.class, args);
		System.out.println("server up");
	}

}
