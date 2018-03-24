package com.yahoo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedDFS {
	public static void main(String args[]) {
		long a = -214748364;
		long b = -214748364;
		long c = a & b;
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		System.out.println(" ** " + c);
	}
	public static void main2(String args[]) {
		List<String> nodes = new ArrayList<>();
		nodes.add("0");
		nodes.add("1");
		nodes.add("2");
		nodes.add("3");
		nodes.add("4");
		
		Map<String, List<String>> adjs = new HashMap<>();
		List<String> mnodes = new ArrayList<>();
		mnodes.add("1");
		mnodes.add("4");
		adjs.put("0", mnodes);
		
		List<String> nnodes = new ArrayList<>();
		nnodes.add("0");
		nnodes.add("4");
		nnodes.add("2");
		nnodes.add("3");
		adjs.put("1", nnodes);
		
		List<String> onodes = new ArrayList<>();
		onodes.add("1");
		onodes.add("3");
		adjs.put("2", onodes);
		
		List<String> pnodes = new ArrayList<>();
		pnodes.add("1");
		pnodes.add("4");
		pnodes.add("2");
		adjs.put("3", pnodes);
		
		List<String> qnodes = new ArrayList<>();
		qnodes.add("3");
		qnodes.add("0");
		qnodes.add("1");
		adjs.put("4", qnodes);
		
		System.out.println(dfs(nodes, adjs));
	}
	
	public static boolean dfs(List<String> nodes, Map<String, List<String>> adjs) {
		List<String> visited = new ArrayList<>();
		boolean cycle = isCycle("0", "-1", visited, adjs);
		return cycle;
	}
	
	public static boolean isCycle(String node, String parent, List<String> visited, 
			Map<String, List<String>> adjs) {
		if (visited.contains(node)) {
			return true;
		}
		
		visited.add(node);
		boolean cycle = false;
		for (String edge : adjs.get(node)) {
			if (!edge.equals(parent)) {
				cycle = cycle || isCycle(edge, node, visited, adjs);
				
				if (cycle) {
					return true;
				}
			}
		}
		return cycle;
	}
}
