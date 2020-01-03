package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SimpleLoginSpringBootApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SimpleLoginSpringBootApplication.class, args);
	}
	
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.optimum.employeedashboardtest")).build();
	}
	// to access API list in swagger
	// http://localhost:8090/swagger-ui.html#

}
