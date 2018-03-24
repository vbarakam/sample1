package com.yahoo.util;

import java.util.HashMap;
import java.util.Map;

public class ReverseString {
	public static void main(String args[]) {
		System.out.println(reverseString("hello"));
	}
	
	public static String reverseString(String s) {
		Map<Integer,Integer> cache = new HashMap<>();
        char c[] = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while (start < s.length()/2) {
            char temp = c[end];
            c[end] = c[start];
            c[start] = temp;
            start++;
            end--;
        }
        return new String(c);
    }
}
