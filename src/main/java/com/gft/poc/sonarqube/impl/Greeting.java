package com.gft.poc.sonarqube.impl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	private static final Logger log = LoggerFactory.getLogger(Greeting.class);
	
	@RequestMapping("/greeting")
	public String getGreeting() {
		log.debug("Generic greeting");
		return "Hello, World!";
	}

	@RequestMapping("/greeting/{name}")
	public String getGreeting(@PathVariable String name) {
		log.debug("Greeting for {}", name);
		return "Hello, " + name + "!";
	}
	
	@RequestMapping("/error/{name}")
	public String error(@PathVariable String name) {
		try {
			throw new IllegalArgumentException(name);
		} catch (IllegalArgumentException e) {
			log.error("error: ", e);
			throw e;
		}
	}
}
