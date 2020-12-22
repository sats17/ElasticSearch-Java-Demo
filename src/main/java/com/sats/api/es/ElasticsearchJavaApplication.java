package com.sats.api.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(exclude = {})
public class ElasticsearchJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchJavaApplication.class, args);
		log.info("Application is now running on PORT 9999");
	}

}
