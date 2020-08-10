package com.city.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.city.demo.graph.Graph;

@SpringBootTest
@RunWith(JUnitPlatform.class)
public class GraphTest {

	@Autowired
	Graph graph;

	@Mock
	ConfigProperties properties;

	@Test
	void addNodeTest() {
		int initialSize = graph.getNodesMap().size();
		graph.addNode("A", "B");
		Assertions.assertEquals(initialSize + 1, graph.getNodesMap().size());
	}

	@Test
	void isConnectedSuccessTest() {
		Assertions.assertEquals(true, graph.isConnected("philly", "boston"));
	}

	@Test
	void isConnectedFailureTest() {
		Assertions.assertEquals(false, graph.isConnected("philly", "bos"));
	}

}
