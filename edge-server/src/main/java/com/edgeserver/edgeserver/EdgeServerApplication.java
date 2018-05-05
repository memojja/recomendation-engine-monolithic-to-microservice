package com.edgeserver.edgeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient

public class EdgeServerApplication {


	public static void main(String[] args) {
//		Object[] sources = {EdgeServerApplication.class, new ClassPathResource("groovy/ExampleSurgicalDebugFilterBean.groovy")};
//		SpringApplication.run(sources, args);
		SpringApplication.run(EdgeServerApplication.class, args);
	}
}
