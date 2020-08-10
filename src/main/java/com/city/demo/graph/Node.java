package com.city.demo.graph;

import java.util.HashSet;
import java.util.Set;

public class Node {
	String city;
	Set<Node> adjacentCities = new HashSet<>();

	public Node(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Node> getAdjacentCities() {
		return adjacentCities;
	}

	public void addAdjacentCity(Node adjacentCity) {
		this.adjacentCities.add(adjacentCity);
	}

	public boolean isAdjacentCity(Node adjacentCity) {
		return this.adjacentCities.contains(adjacentCity);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) {
			return false;
		}
		Node n1 = (Node) obj;
		return this.city.equals(n1.getCity());
	}

	@Override
	public int hashCode() {
		return this.city.hashCode();
	}

	@Override
	public String toString() {
		return this.city;
	}
}
