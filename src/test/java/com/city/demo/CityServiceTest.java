package com.city.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

import com.city.demo.graph.Graph;

@SpringBootTest
public class CityServiceTest {

	@InjectMocks
	CityService service;

	@Mock
	private Graph graph;

	@Test
	void getCityConnectionsSuccessTest() {
		when(graph.isConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
		Assertions.assertEquals(true, service.getCityConnections("Philly", "Boston"));
	}
	
	@Test
	void getCityConnectionsFailureTest() {
		when(graph.isConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
		Assertions.assertEquals(false, service.getCityConnections("new", "Boston"));
	}
}
