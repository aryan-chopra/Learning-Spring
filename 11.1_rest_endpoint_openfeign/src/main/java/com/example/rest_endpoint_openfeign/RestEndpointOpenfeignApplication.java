package com.example.rest_endpoint_openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestEndpointOpenfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEndpointOpenfeignApplication.class, args);
	}

}
