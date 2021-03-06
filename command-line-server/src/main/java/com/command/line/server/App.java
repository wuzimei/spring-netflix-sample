package com.command.line.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.command.line.server.factory.Command;
import com.command.line.server.factory.CommandFactory;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class App {

	private static ApplicationContext ac;
	
	public static void main(String[] args) {
		ac = SpringApplication.run(App.class, args);
	}
	
	public static ApplicationContext getApplicationContext() {
		return ac;
	}

	@RequestMapping(value = "/command", method = RequestMethod.POST)
	@ResponseBody
	public String command(@RequestBody String command) throws Exception {
		System.out.println("command: " + command);
		if (!validate(command)) {
			return "command format error.";
		}

		Command cmd = CommandFactory.create(command);
		return cmd.wrapRun();

	}

	private boolean validate(String command) {
		return true;
	}

}
