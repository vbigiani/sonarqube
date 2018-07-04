package com.gft.poc.sonarqube.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingTests {
	@Autowired
	private Greeting greeting;

	@Test
	public void testGreeting() {
		Assert.assertEquals("http://www.google.com?password=P4$$w0rd&userName=userName", greeting.getGreeting());
	}
}
