package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.services.BloodDonarService;

@SpringBootApplication
public class SpringMvcWithJspApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=	SpringApplication.run(SpringMvcWithJspApplication.class, args);
		
		BloodDonarService service = ctx.getBean(BloodDonarService.class);
		
		service.findByBloodGroup("bve").forEach(System.out::println);
	}

}
