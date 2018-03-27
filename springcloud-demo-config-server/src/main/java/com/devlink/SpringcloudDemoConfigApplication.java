package com.devlink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcloudDemoConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudDemoConfigApplication.class, args);
	}
}
