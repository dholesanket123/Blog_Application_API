package com.SanketIT.Blog_App;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	
	// create model mapper class and @bean for add create objet 
	@Bean
     public ModelMapper modelMapper() {
    	 return new  ModelMapper();
     }
}
