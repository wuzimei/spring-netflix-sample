package com.wzm.service.ip.location;

import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		URL url = App.class.getResource("ipdb.dat");
		IP.load(url.getFile());
	}
}
