package com.sats.api.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ElasticsearchJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchJavaApplication.class, args);
		log.info("Application is now running on PORT 9999");
	}

}
