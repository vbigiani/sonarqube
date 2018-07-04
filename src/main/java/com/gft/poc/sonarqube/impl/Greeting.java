package com.gft.poc.sonarqube.impl;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
	public String getGreeting() {
		return "http://www.google.com?password=P4$$w0rd&userName=userName";
	}
}
