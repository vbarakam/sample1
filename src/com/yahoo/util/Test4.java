package com.yahoo.util;

import java.util.ArrayList;
import java.util.*;

public class Test4 {
	public static int timer = 0;

	public static void main(String args[]) {
		// list of node
		List<String> nodes = new ArrayList<>();
		nodes.add("1");
		nodes.add("2");
		nodes.add("3");
		nodes.add("4");
		nodes.add("5");
		nodes.add("6");

		Map<String, List<String>> adjs = new HashMap<>();
		List<String> mnodes = new ArrayList<>();
		mnodes.add("2");
		mnodes.add("3");
		mnodes.add("4");
		adjs.put("1", mnodes);

		List<String> nnodes = new ArrayList<>();
		nnodes.add("3");
		adjs.put("2", nnodes);

		List<String> onodes = new ArrayList<>();
		adjs.put("3", onodes);

		List<String> pnodes = new ArrayList<>();
		pnodes.add("5");
		adjs.put("4", pnodes);

		List<String> qnodes = new ArrayList<>();
		qnodes.add("6");
		adjs.put("5", qnodes);

		List<String> rnodes = new ArrayList<>();
		//rnodes.add("4");
		adjs.put("6", rnodes);

		System.out.println(" count " +  checkCycles(nodes, adjs));
	}
	
	public static boolean checkCycles(List<String> nodes, Map<String, List<String>> adjs) {
		// initialize
		Map<String, Integer> colors = new HashMap<>();
		for (String node : nodes) {
			colors.put(node, 0);
		}
		
		boolean cycles = false;
		for (String node : nodes) {
			if (colors.get(node) == 0) {
				cycles = cycles || dfsVisit(node, adjs, colors);
			}
		}
		return cycles;
	}
	
	public static boolean dfsVisit(String node, 
			Map<String, List<String>> adjs,
			Map<String, Integer> colors) {
		// change the color to grey
		colors.put(node, 1);
		
		boolean cycles = false;
		for (String edge : adjs.get(node)) {
			// node refering to grey node indicates  a cycle
			if  (colors.get(edge) == 1) {
				return true;
			} else if (colors.get(edge) == 0) {
				cycles = cycles || dfsVisit(edge, adjs, colors);
			}
		}
		
		// change the color to black
		colors.put(node, 2);
		return cycles;
	}
}
