package com.sky.dvdstore;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class WebServiceFixture {

	public String greetingFor(String firstName) {

		return "Hello " + firstName + "!";
	}
}
