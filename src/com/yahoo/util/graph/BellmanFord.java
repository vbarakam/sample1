package com.yahoo.util.graph;

import java.util.*;

public class BellmanFord {

	private static final Integer INFINITY = 1000000;
	
	public Map<Integer, Integer> getShortestPath(Graph<Integer> graph,
            Vertex<Integer> sourceVertex) {
		Map<Integer, Integer> distance = new HashMap<>();
		Map<Integer, Vertex<Integer>> parents = new HashMap<>();
		// populate distance to infinity and parents to null
		for (Map.Entry<Integer, Vertex<Integer>> v : graph.getAllVertex().entrySet()) {
			distance.put(v.getKey(), INFINITY);
			parents.put(v.getKey(), null);
		}
		
		// 
		distance.put(sourceVertex.getId(), 0);
		
		// vertex size - 1
		for (int index = 0; index < graph.getAllVertex().size() -1; index++) {
			for (Map.Entry<Integer, Vertex<Integer>> entry : graph.getAllVertex().entrySet()) {
				for (Edge<Integer> edge : entry.getValue().getEdges()) {
					if (distance.get(entry.getKey()) > distance.get(entry.getKey()) + edge.getWeight()) {
						distance.put(entry.getKey(), distance.get(entry.getKey()) + edge.getWeight());
					}
				}
			}
		}
		
		// check if negative weight cycle exists
		for (Map.Entry<Integer, Vertex<Integer>> entry : graph.getAllVertex().entrySet()) {
			for (Edge<Integer> edge : entry.getValue().getEdges()) {
				if (distance.get(entry.getKey()) > distance.get(entry.getKey()) + edge.getWeight()) {
					//distance.put(entry.getKey(), distance.get(entry.getKey()) + edge.getWeight());
					return null;
				}
			}
		}
		return distance;
	}
	public static void main(String args[]) {
		Graph<Integer> graph = new Graph<>(false);
		graph.addEdge(0, 3, 8);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(1, 2, -3);
		graph.addEdge(2, 4, 4);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 3, 1);
		
		BellmanFord shortestPath = new BellmanFord();
        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
        Map<Vertex<Integer>,Integer> distance = shortestPath.getShortestPath(graph, startVertex);
        System.out.println(distance);
	}
}
