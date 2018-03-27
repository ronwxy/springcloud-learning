package com.devlink;

import com.devlink.filter.error.CustomFilterProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class SpringcloudDemoZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudDemoZuulApplication.class, args);
		FilterProcessor.setProcessor(new CustomFilterProcessor());
	}
}
