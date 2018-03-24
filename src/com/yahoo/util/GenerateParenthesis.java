package com.yahoo.util;

import java.util.*;

public class GenerateParenthesis {

	public static void main(String args[]) {
		System.out.println(generateParenthesis(3));
	}
	
	 public static List<String> generateParenthesis(int n) {
	        List<String> params = new ArrayList<>();
	        if (n == 0) {
	            return params;
	        }
	        
	        if (n == 1) {
	            params.add("()");
	            return params;
	        }
	        int cs[] = {n, n};
	        char ch[] = {'(', ')'};
	        char temp [] = new char[n*2];
	        generate(ch, cs, temp, params, 0, n*2);
	        
	        return params;
	    }
	    
	    public static boolean generate(char ch[], int cs[], char temp [], List<String> results, int level, int max) {
	        if (level == max) {
	        	System.out.println(temp);
	            if (validParams(temp)) {
	                StringBuilder builder = new StringBuilder();
	                for (char c : temp) {
	                    builder.append(c);
	                }
	                results.add(builder.toString());
	                return true;
	            } else {
	                return false;
	            }
	        }
	        // base condition
	        for (int i = 0; i < ch.length; i++) {
	            if (cs[i] > 0) {
	                cs[i] = cs[i] - 1;
	                temp[level] = ch[i];
	                
	                // validate the char
	                boolean status = validString(temp, level);
	                System.out.println(status);
	                if (status) {
	                    generate(ch, cs, temp, results, level + 1, max);
	                }
	                cs[i] += 1;
	            }
	        }
	        
	        return false;
	    }
	    
	    public static boolean validParams(char temp []) {
	    	System.out.println("validParams ");
	        Stack<Character> stack = new Stack<>();
	        for (int index = 0; index < temp.length; index++) {
	            if (temp[index] == ')') {
	                if (!stack.isEmpty() && stack.peek() == '(') {
	                    stack.pop();
	                } else {
	                    return false;
	                }
	            } else {
	                stack.push(temp[index]);
	            }
	        }
	        
	        if (!stack.empty()) {
	            return false;
	        } else {
	            return true;
	        }
	    }
	    
	    public static boolean validString(char temp [], int level) {
	        int close = 0;
	        int open = 0;
	        for (int index = 0; index <= level; index++) {
	            if (temp[index] == ')') {
	                close += 1;
	            } else {
	                open += 1;
	            }
	        }
	        
	        if (close > open) {
	            return false;
	        } else {
	            return true;
	        }
	    }
}
