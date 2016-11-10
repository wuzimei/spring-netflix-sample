package com.wzm.zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.wzm.zuul.gateway.filter.AuthFilter;
import com.wzm.zuul.gateway.filter.LogFilter;

@EnableZuulProxy
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public AuthFilter authFilter() {
		return new AuthFilter();
	}
	
	@Bean
	public LogFilter logFilter() {
		return new LogFilter();
	}

}
