package com.hrm.hrmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HrmserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmserviceApplication.class, args);
	}

}
