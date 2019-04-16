package com.laptop.infra.application.athome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@ComponentScan({ "com.laptop" })
public class RestApplication {
	private static final Logger log = LoggerFactory.getLogger(RestApplication.class);

	@EventListener
	public void handleApplicationEvent(ApplicationReadyEvent readyEvent) {
		ConfigurableEnvironment env = readyEvent.getApplicationContext().getEnvironment();
		String instanceId = env.getProperty("app.instance");
		log.info("{} is ready with instance ID: {}", env.getProperty("spring.application.name"), instanceId);
	}

	public static void main(String[] args) {
		log.info("Application starting ...");
		SpringApplication.run(RestApplication.class, args);
	}
}
