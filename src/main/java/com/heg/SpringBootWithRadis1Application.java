package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootWithRadis1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithRadis1Application.class, args);
	}

}
