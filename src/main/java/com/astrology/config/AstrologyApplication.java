package com.astrology.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AstrologyApplication
{
	public static void main(String[] args)
	{
		System.out.println("----------> Start!! <----------");
		SpringApplication.run(AstrologyApplication.class, args);
	}

}
