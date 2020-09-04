package com.sats.api.es.config;

import java.util.Collections;

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

	@Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
        	.select()
            .paths(PathSelectors.ant("/api/restaurants/*"))
            .build()
            .apiInfo(apiInfo());
    }
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Elastic Search CRUD API", 
	      "CRUD Operations for elastic search using Java-Spring boot", 
	      "1.0", 
	      "Free to use", 
	      new Contact("Sats17", "www.github.com/sats17", "satishkumbhar9999@gmail.com"), 
	      "License of API",
	      "API license URL",
	      Collections.emptyList());
	}
	
}