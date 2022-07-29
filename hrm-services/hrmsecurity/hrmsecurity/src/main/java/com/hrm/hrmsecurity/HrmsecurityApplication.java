package com.hrm.hrmsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrmsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsecurityApplication.class, args);
	}

}
