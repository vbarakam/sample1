package com.yahoo.util3;

import java.util.Arrays;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
	public static void main(String args[]) {
		String strs [] = {"0:start:0",
		                  "1:start:2",
		                  "1:end:5",
		                  "0:end:6"};
		String strs2 [] = {"0:start:0",
		 "0:start:2",
		 "0:end:5",
		 "1:start:7",
		 "1:end:7",
		 "0:end:8"};
		int n = 2;
		System.out.println(Arrays.toString(exclusiveTime2(n, strs2)));
	}
	public static int[] exclusiveTime2(int n, String logs[]) {
        int results[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for (String log : logs) {
        	String splits[] = log.split(":");
        	
        	if (!stack.isEmpty()) {
        		results[stack.peek()] += Integer.parseInt(splits[2]) - prev; 
        	}
        	prev = Integer.parseInt(splits[2]);
        	
        	if (splits[1].equals("start")) {
        		stack.push(Integer.parseInt(splits[0]));
        	} else {
        		prev++;
        		results[stack.pop()]++;
        	}
        }
        return results;
	}
	public static int[] exclusiveTime(int n, String logs[]) {
        int results[] = new int[n];
        for (int i = 0; i < logs.length-1; i++) {
            String first = logs[i];
            String fsplits[] = first.split(":");
            String second = logs[i+1];
            String ssplits[] = second.split(":");
            if (!fsplits[0].equals(ssplits[0]) && fsplits[1].equals("start") && ssplits[1].equals("start") ) {
            	results[Integer.parseInt(fsplits[0])] += Integer.parseInt(ssplits[2]) - Integer.parseInt(fsplits[2]);
            } else if (!fsplits[0].equals(ssplits[0]) && fsplits[1].equals("end") && ssplits[1].equals("end") ) {
            	results[Integer.parseInt(ssplits[0])] += Integer.parseInt(ssplits[2]) - Integer.parseInt(fsplits[2]);
            } else {
            	results[Integer.parseInt(fsplits[0])] += Integer.parseInt(ssplits[2]) - Integer.parseInt(fsplits[2]);
            }
            if (fsplits[0].equals(ssplits[0])) {
            	results[Integer.parseInt(fsplits[0])]++;
            }
        }
        return results;
    }
}
