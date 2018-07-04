package com.gft.poc.sonarqube.impl;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
	public String getGreeting() {
		StringBuilder sb = new StringBuilder();
		sb.append("http://");
		sb.append("www.google.com?password=P4$$w0rd&userName=userName");
		return sb.toString();
			
	}
}
