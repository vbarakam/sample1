package com.yahoo.util;

import java.util.*;

public class ReversePolish {
	public static void main(String args[]) {
		//
		//"2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
		//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
		
		//String nums [] =  {"2", "1", "+", "3", "*"};
		String nums [] = {"4", "13", "5", "/", "+"};
		Stack<Integer> s = new Stack<>();
		for (String num : nums) {
			if (num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
				// perform the operation
				Integer second = s.pop();
				Integer first = s.pop();
				Integer result = 0;
				if (num.equals("+")) {
					result = first + second;
				} else if (num.equals("-")) {
					result = first - second;
				} else if (num.equals("/")) {
					result = first / second;
				} else {
					//num.equals("*")
					result = first * second;
				}
				s.push(result);
			} else {
				// add to the stack
				s.push(new Integer(num));
			}
		}
		System.out.println(s.peek());
	}
}
