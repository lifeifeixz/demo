package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author flysLi
 */
@EnableEurekaServer
@SpringBootApplication
public class ConfigEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigEurekaApplication.class, args);
	}
}
