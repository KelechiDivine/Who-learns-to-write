package com.whowritesblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhoWritesBlogApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WhoWritesBlogApplication.class, args);
		System.out.println("Successfully ran chat  application.");
	}
}
