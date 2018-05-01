package com.example.movieservice.movieservice;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@SpringBootApplication
//@EnableCaching
@EnableAsync
@EnableDiscoveryClient

public class MovieServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	@Bean
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(25);
		executor.setThreadNamePrefix("Recomendation-");
		executor.initialize();
		return executor;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

//	private ClientHttpRequestFactory getClientHttpRequestFactory() {
//		int timeout = 999999999;
//		RequestConfig config = RequestConfig.custom()
//				.setConnectTimeout(timeout)
//				.setConnectionRequestTimeout(timeout)
//				.setSocketTimeout(timeout)
//				.build();
//		CloseableHttpClient client = HttpClientBuilder
//				.create()
//				.setDefaultRequestConfig(config)
//				.build();
//		return new HttpComponentsClientHttpRequestFactory(client);
//	}

}
