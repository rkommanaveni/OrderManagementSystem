package com.dbs.orderservice.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

private static final Logger log=LoggerFactory.getLogger(SwaggerConfig.class);
	
	@Value("${enable.swagger.plugin}")
	private boolean enableSwaggerplugin;
	private final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));

	@Bean
	public Docket api() {         
		log.info("enableSwaggerplugin"+enableSwaggerplugin);
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.any())
	      .paths(PathSelectors.any())
	      .build()
	      .enable(enableSwaggerplugin)
	      .apiInfo(getApiInfo())
	      .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
	      .produces(DEFAULT_PRODUCES_AND_CONSUMES);
	    
	    
	}

	private ApiInfo getApiInfo() {
		
		log.info("started getApiInfo");
	    return new ApiInfo(
	      "ORDER MANAGEMENT SYSTEM", "Some custom description of ORDER MANAGEMENT SYSTEM API.", "1.0.0", "Terms of service", 
	      new Contact("Ramesh Kommanaveni", "www.example.com", "rameshkommanaveni@company.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}
	
}