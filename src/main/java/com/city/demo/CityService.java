package com.city.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.city.demo.graph.Graph;

@Service
public class CityService {

	@Autowired
	private Graph graph;

	public boolean getCityConnections(String origin, String destination) {
		return graph.isConnected(origin.toLowerCase(), destination.toLowerCase());
	}

}
