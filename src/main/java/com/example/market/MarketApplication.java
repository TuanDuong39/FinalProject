package com.example.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args)
	{
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String rawPassword = "123";
//		String encodedPassword = encoder.encode(rawPassword);
//		System.out.println( encodedPassword);
		SpringApplication.run(MarketApplication.class, args);
	}

}
