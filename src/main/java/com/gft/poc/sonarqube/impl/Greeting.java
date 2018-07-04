package com.gft.poc.sonarqube.impl;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
	public String getGreeting() {
		return "Hello, World!";
	}
}
