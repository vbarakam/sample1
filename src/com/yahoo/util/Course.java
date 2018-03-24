package com.yahoo.util;

import java.util.*;

public class Course {

	public static void main(String args[]) {
		List<Integer> nodes = new ArrayList<>();
		Map<Integer, List<Integer>> edges = new HashMap<>();
		nodes.add(0);
		nodes.add(1);
		

		List<Integer> qnodes = new ArrayList<>();
		qnodes.add(0);
		edges.put(1, qnodes);
		
		List<Integer> dnodes = new ArrayList<>();
		dnodes.add(1);
		edges.put(0, dnodes);
		
		System.out.println(nodes);
        System.out.println(edges);
		System.out.println(" :: " +  checkCycles(nodes, edges ));
		System.out.println(" :: " +  dfs(nodes, edges ));
	}
	
	public static boolean dfs(List<Integer> nodes, Map<Integer, List<Integer>> edges) {
        // initialize
        Map<Integer, Integer> colors = new HashMap<>();
        Map<Integer, Timer> timers = new HashMap<>();
        for (Integer node : nodes) {
            colors.put(node, 0);
            timers.put(node, new Timer());
        }
        
        boolean cycle = false;
        for (Integer node : nodes) {
            if (colors.get(node) == 0) {
                cycle = cycle || dfsVisit(node, edges, colors);
            }
        }
        return cycle;
    }
    
    public static boolean dfsVisit(Integer node, Map<Integer, List<Integer>> edges, Map<Integer, Integer> colors) {
        // set the color to grey
        boolean cycle = false;
        colors.put(node, 1);
        
        // process the edges
        for (Integer edge : edges.get(node)) {
            if (colors.get(edge) == 1) {
                return true;
            } else if (colors.get(edge) == 0) {
                cycle = cycle || dfsVisit(edge, edges, colors);
            }
        } 
        
        // set the color to black
        colors.put(node, 2);
        
        return cycle;
    }
    
    static class Timer {
        int pre;
        int post;
    }
    
    public static boolean checkCycles(List<Integer> nodes, Map<Integer, List<Integer>> adjs) {
		// initialize
		Map<Integer, Integer> colors = new HashMap<>();
		for (Integer node : nodes) {
			colors.put(node, 0);
		}
		
		boolean cycles = false;
		for (Integer node : nodes) {
			if (colors.get(node) == 0) {
				cycles = cycles || dfsVisit2(node, adjs, colors);
			}
		}
		return cycles;
	}
	
	public static boolean dfsVisit2(Integer node, 
			Map<Integer, List<Integer>> adjs,
			Map<Integer, Integer> colors) {
		// change the color to grey
		colors.put(node, 1);
		
		boolean cycles = false;
		for (Integer edge : adjs.get(node)) {
			// node refering to grey node indicates  a cycle
			if  (colors.get(edge) == 1) {
				return true;
			} else if (colors.get(edge) == 0) {
				cycles = cycles || dfsVisit2(edge, adjs, colors);
			}
		}
		
		// change the color to black
		colors.put(node, 2);
		return cycles;
	}
}
