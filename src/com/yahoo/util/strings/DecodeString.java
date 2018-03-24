package com.yahoo.util.strings;

import java.util.Stack;

public class DecodeString {
	public static void main(String args[]) {
		String input = "100[leetcode]";
		System.out.println(decodeString(input));
	}
	
    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            // check for closing ]
            if (s.charAt(index) == ']') {
                // pop upto last [
                StringBuilder inner = new StringBuilder();
                while (!stack.empty() && stack.peek() != '[') {
                    inner.append(stack.pop());
                }
                if (stack.peek() == '[') {
                    // remove open [
                    stack.pop();
                    if (!stack.empty()) {
                        StringBuilder number = new StringBuilder();
                    	 while (!stack.empty() && stack.peek() >= '0' && stack.peek() <= '9') {
                             number.append(stack.pop());
                         }
                         int repeat = new Integer(number.reverse().toString());
                        StringBuilder ss = new StringBuilder();
                        String pp = inner.reverse().toString();
                        for (int i = 0; i < repeat; i++) {
                            ss.append(pp);
                        }
                        
                        // push to stack
                        for (char c : ss.toString().toCharArray()) {
                            stack.push(c);
                        }
                    }
                }
            } else {
                stack.push(s.charAt(index));
            }
        }
        
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }
}
