package com.yahoo.util.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Dijkstras {

	public static void main(String args[]) {
		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 5);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 1);
		graph.addEdge(2, 3, 9);
		graph.addEdge(2, 1, 3);
		graph.addEdge(2, 4, 2);
		graph.addEdge(3, 4, 4);
		graph.addEdge(4, 0, 7);
		graph.addEdge(4, 3, 6);
		
		System.out.println(graph.getAllVertex());
		
		// for all the nodes make distance as infinity
		Iterator<Map.Entry<Integer, Vertex<Integer>>> entry = graph.getAllVertex().entrySet().iterator();
		while (entry.hasNext()) {
			entry.next().getValue().setData(Integer.MAX_VALUE);
		}
		
		graph.getAllVertex().get(new Integer(0)).distance = 0;
		System.out.println(graph.getAllVertex());
		
		// queue with all the elements
		Queue<Vertex<Integer>> queue = new PriorityQueue<Vertex<Integer>>((first, second) -> first.distance - second.distance);
		Iterator<Map.Entry<Integer, Vertex<Integer>>> entry2 = graph.getAllVertex().entrySet().iterator();
		while (entry2.hasNext()) {
			queue.offer(entry2.next().getValue());
		}
		
		// selected nodes
		List<Vertex<Integer>> set = new ArrayList<>();
		while (!queue.isEmpty()) {
			Vertex<Integer> min = queue.peek();
			set.add(min);
			List<Edge<Integer>> edges = min.getEdges();
			for (Edge<Integer> edge : edges) {
				if (edge.getVertex2().distance > min.distance + edge.getWeight()) {
					edge.getVertex2().distance =  min.distance + edge.getWeight();
				}
			}
			queue.poll();
		}
		
		System.out.println(set);
		System.out.println(graph.getAllVertex());
	}
}
