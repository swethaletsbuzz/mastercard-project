package com.city.demo.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.city.demo.ConfigProperties;

@Component
public class Graph {

	@Autowired
	private ConfigProperties properties;

	int vertices;
	Map<String, Node> nodesMap = new HashMap<>();

	@PostConstruct
	public void init() throws Exception {
		BufferedReader reader = null;
		String line = null;
		try {
			String fileName = properties.getCityFile();
			reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				String[] arr = line.split(",");
				String origin = StringUtils.trimWhitespace(arr[0]).toLowerCase();
				String destination = StringUtils.trimWhitespace(arr[1]).toLowerCase();
				addNode(origin, destination);
				addNode(destination, origin);
			}
		} catch (Exception e) {
			// LOG and Exit program;
			e.printStackTrace();
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public Map<String, Node> getNodesMap() {
		return nodesMap;
	}

	public void setNodesMap(Map<String, Node> nodesMap) {
		this.nodesMap = nodesMap;
	}

	public void addNode(String origin, String destination) {
		Node originNode = nodesMap.get(origin);
		if (originNode == null) {
			originNode = new Node(origin);
			nodesMap.put(origin, originNode);
		}
		Node destinationNode = new Node(destination);
		if (nodesMap.containsKey(destination)) {
			destinationNode = nodesMap.get(destination);
		}
		originNode.addAdjacentCity(destinationNode);
	}

	public boolean isConnected(String origin, String destination) {
		Queue<String> queue = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();
		Node destinationNode = new Node(destination);
		queue.offer(origin);
		while (!queue.isEmpty()) {
			String currentCity = queue.poll();
			Node currentNode = nodesMap.get(currentCity);
			if (currentNode == null) {
				return false;
			}
			if (currentNode.getAdjacentCities().contains(destinationNode)) {
				return true;
			} else {
				Set<Node> neighbours = currentNode.getAdjacentCities();
				neighbours.forEach(n -> {
					if (!visited.contains(n.getCity())) {
						queue.offer(n.getCity());
					}
				});
			}
			visited.add(currentCity);
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String key : this.nodesMap.keySet()) {
			sb.append(key).append(" -> ");
			Node node = this.nodesMap.get(key);
			Set<Node> adjacentCities = node.getAdjacentCities();
			for (Node n : adjacentCities) {
				sb.append(n.city).append(",");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
