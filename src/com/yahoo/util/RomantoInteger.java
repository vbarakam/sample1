package com.yahoo.util;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
	private static Map<String, Integer> mapping = new HashMap<>();
    static {
        mapping.put("I", 1);
        mapping.put("IV", 4);
        mapping.put("V", 5);
        mapping.put("IX", 9);
        mapping.put("X", 10);
        mapping.put("XL", 40);
        mapping.put("L", 50);
        mapping.put("XC", 90);
        mapping.put("C", 100);
        
        mapping.put("CD", 400);
        mapping.put("D", 500);
        mapping.put("M", 1000);
        mapping.put("CM", 900);

    }
	public static void main(String args[]) {
		System.out.println( " test " + "str".substring(0, 0));
		System.out.println(romanToInt("MMCMLXXXIX"));
	}
	
	public static int romanToInt(String s) {
        int total = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String key = null;
            if ((i + 1) < s.length()) {
                key = s.substring(i, i + 2);
                if (mapping.containsKey(key)) {
                    total += mapping.get(key);
                    i = i + 1;
                    continue;
                }
            } 
            
            key = s.substring(i, i + 1);
            if (mapping.containsKey(key)) {
                total += mapping.get(key);
            }
        }
        return total;
    }
}
