package com.yahoo.util3;

import java.util.*;

public class DecodeString {
	public static void main(String args[]) {
		DecodeString decode = new DecodeString();
		decode.decodeString("3[a2[c]]");
	}

	 public String decodeString(String s) {
	        Stack<String> stack = new Stack<String>();
	        Integer num = 1;
	        String res = "";
	        for (int i = 0; i < s.length();) {
	            if (Character.isDigit(s.charAt(i))) {
	                num = 0;
	                while (Character.isDigit(s.charAt(i)) && i < s.length()) {
	                    num = num * 10 + (s.charAt(i++) - '1' + 1);
	                }
	            } else if (s.charAt(i) == '[') {
	                stack.push(res);
	                stack.push(num.toString());
	                num = 0;
	                res = "";
	                System.out.println(stack);
	                i++;
	            } else if (s.charAt(i) == ']') {
	                StringBuilder sb = new StringBuilder();
	                int limit = Integer.parseInt(stack.pop());
	                for (int j = 0; j < limit; j++) {
	                    sb.append(res);
	                }
	                res = sb.toString();
	                i++;
	            } else {
	                res = res + s.charAt(i++);
	                System.out.println(res);
	            }
	        }
	        StringBuilder sb2 = new StringBuilder();
	        sb2.append(res);
	        while (!stack.isEmpty()) {
	            sb2.insert(0, stack.pop());
	        }
	        return sb2.toString();
	    }
}
