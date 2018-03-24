package com.yahoo.util;

import java.util.*;

public class APath {
	public static void main(String args[]) {
		String p1 = "/home/../test";
		String p = "/a/../b/../../c/";
		String splits[] = p.split("/");
		System.out.println(splits.length);
		
		
		
		Stack<String> stack = new Stack<>();
		for (String split : splits) {
			stack.push(split);
		}

		List<String> ss = new ArrayList<>();
		int skip = 0;
		while (!stack.empty()) {
			
			if (stack.peek().trim().length() == 0) {
				stack.pop();
				continue;
			}
			
			if (stack.peek().equals("..")) {
				skip++;
				stack.pop();
				continue;
			}
			
			boolean ski = false;
			if (skip > 0) {
				ski = true;
				stack.pop();
				skip -= 1;
			}
			if (ski) {
				continue;
			}
			
			ss.add(stack.peek());
			stack.pop();
		}
		
		System.out.println(ss);
		
		StringBuilder sb = new StringBuilder();
		
		if (ss.size() > 0) {
			sb.append("/");
		}
		
		for (int i = ss.size() - 1; i >= 0 ; i--) {
			if (sb.length() > 1) {
				sb.append("/");
			}
			sb.append(ss.get(i));
		}
		
		System.out.println(sb.toString());
	}
}
