package com.yahoo.util.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph2<T> {
	private List<Edge2<T>> allEdges = null;
	private Map<Long, Vertex2<T>> allVertex = null;
	private boolean isDirected;

	public Graph2(boolean isDirected) {
		this.isDirected = isDirected;
		allVertex = new HashMap<>();
		allEdges = new ArrayList<>();
	}

	public void addEdge(long id1, long id2) {
		Vertex2<T> first = null;
		if (allVertex.containsKey(id1)) {
			first = allVertex.get(id1);
		} else {
			first = new Vertex2(id1);
			allVertex.put(id1, first);
		}

		Vertex2<T> second = null;
		if (allVertex.containsKey(id2)) {
			first = allVertex.get(id2);
		} else {
			second = new Vertex2(id2);
			allVertex.put(id2, second);
		}
		Edge2<T> edge = new Edge2(first, second, isDirected, 0);
		allEdges.add(edge);
		first.addAdjacentVertex(second, edge);
		if (!isDirected) {
			second.addAdjacentVertex(first, edge);
		}
	}
}

class Vertex2<T> {
	private long id;
	private T data;
	private List<Vertex2<T>> adjacentVertex = new ArrayList<>();
	private List<Edge2<T>> edges = new ArrayList<>();

	public Vertex2(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void addAdjacentVertex(Vertex2<T> v, Edge2<T> edge) {
		this.adjacentVertex.add(v);
		this.edges.add(edge);
	}
	
	public List<Vertex2<T>> getAdjacentVertex() {
		return adjacentVertex;
	}

	public void setAdjacentVertex(List<Vertex2<T>> adjacentVertex) {
		this.adjacentVertex = adjacentVertex;
	}

	public List<Edge2<T>> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge2<T>> edges) {
		this.edges = edges;
	}

	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + (int) id;
		return result;
	}

	public boolean equals(Object otherObject) {
		if (this == otherObject) {
			return true;
		}

		if (otherObject == null) {
			return false;
		}

		if (getClass() != otherObject.getClass()) {
			return false;
		}

		if (!(otherObject instanceof Vertex)) {
			return false;
		}

		Vertex<T> other = (Vertex) otherObject;
		return this.getId() == other.getId();
	}

}

class Edge2<T> {
	private boolean isDirected = false;
	private Vertex2<T> vertex1 = null;
	private Vertex2<T> vertex2 = null;
	private int weight;

	public Edge2(Vertex2<T> vertex1, Vertex2<T> vertex2, boolean isDirected, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
		this.weight = weight;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public Vertex2<T> getVertex1() {
		return vertex1;
	}

	public void setVertex1(Vertex2<T> vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertex2<T> getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertex2<T> vertex2) {
		this.vertex2 = vertex2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean equals(Object otherObject) {
		if (this == otherObject) {
			return true;
		}

		if (otherObject == null) {
			return false;
		}

		if (getClass() != otherObject.getClass()) {
			return false;
		}

		if (!(otherObject instanceof Edge)) {
			return false;
		}

		Edge2<T> other = (Edge2) otherObject;

		if (vertex1 == null) {
			if (other.getVertex1() != null) {
				return false;
			}
		}

		if (vertex2 == null) {
			if (other.getVertex2() != null) {
				return false;
			}
		}
		return vertex1.equals(other.getVertex1()) && vertex2.equals(other.getVertex2());
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (vertex1 == null ? 0 : vertex1.hashCode());
		result = prime * result + (vertex2 == null ? 0 : vertex1.hashCode());
		return result;
	}
}
