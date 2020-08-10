package com.city.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(JUnitPlatform.class)
public class CityControllerTest {

	@InjectMocks
	CityController cityController;

	@Mock
	CityService service;

	@Test
	public void testOriginAsNull() {
		Assertions.assertEquals("no", cityController.getCityConnections("New York", "Hyderabad"));
	}

	@Test
	public void testOriginAsEmpty() {
		Assertions.assertEquals("no", cityController.getCityConnections("New York", "Hyderabad"));
	}

	@Test
	public void testOriginAsWhiteSpace() {
		Assertions.assertEquals("no", cityController.getCityConnections("New York", "Hyderabad"));
	}

	@Test
	public void testDestinationAsNull() {
		Assertions.assertEquals("no", cityController.getCityConnections("New York", "Hyderabad"));
	}

	@Test
	public void testDestinationAsEmpty() {
		Assertions.assertEquals("no", cityController.getCityConnections("New York", "Hyderabad"));
	}

	@Test
	public void testDestinationAsWhiteSpace() {
		Assertions.assertEquals("no", cityController.getCityConnections("New York", "Hyderabad"));
	}

	@Test
	public void testSuccess() {
		when(service.getCityConnections(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
		Assertions.assertEquals("yes", cityController.getCityConnections("New York", "Boston"));
	}

	@Test
	public void testCityNotInFile() {
		Assertions.assertEquals("no", cityController.getCityConnections("New York", "Hyd"));
	}

	@Test
	public void testCityNotConnected() {
		Assertions.assertEquals("no", cityController.getCityConnections("New York", "Orlando"));
	}
}
