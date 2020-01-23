package com.example.mywork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyWorkApplication extends SpringBootServletInitializer {
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
	{ 
		return application.sources(MyWorkApplication.class); 
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(MyWorkApplication.class, args);
	}	
}
