package com.yahoo.util;

import java.util.*;

public class RemoveKElements {

	public static void main(String args[]) {
		String str = "1432219"; //3,1219
		//String str = "10200"; //1,200
		//String str = "10"; // 2, 0
		int k = 3;
		//String str = "1111111";
		//String str = "112";
		//String str = "1234567";
		System.out.println(removeKdigits(str, k));
	}
	public static String removeKdigits(String num, int k) {
        if (num == null) {
            return null;
        }
        
        if (num.length() == k) {
            return "0";
        }
        
        String num2 = smallest(num, k);
        return num2;
    }
	
	//1432219
    //123456
    //111111
	public static String smallest(String num, int k) {
        boolean allSame = true;
        int dropped = 0;
        Stack<Character> chars = new Stack<>();
        for (int j = 1; j < num.length(); j++) {
            if (dropped < k && num.charAt(j-1) > num.charAt(j)) {
                chars.push(num.charAt(j));
                dropped += 1;
            } else {
                chars.push(num.charAt(j-1));
                if ( (j + 1) ==  num.length()) {
                	chars.push(num.charAt(j));
                }
            } 
            
            if (num.charAt(j-1) == num.charAt(j)) {
            	allSame = allSame & true;
            } else {
                allSame = false;
            }
        }
        
        StringBuilder builder = new StringBuilder();
        while (!chars.isEmpty()) {
        	builder.append(chars.pop());
        }
        
        String smallest = builder.toString();

            
        if (smallest.length() != smallest.length() - k) {
        	// all the numbers are equal
        	if (!allSame) {
        		smallest = num.substring(0, num.length() - 1);
            } else {
            	// all the numbers are in ascensing order
            	smallest = num.substring(1);
            }
        }
            
        while (smallest.startsWith("0")) {
        	smallest = smallest.substring(1);
        }
        return smallest.equals("") ? "0" : smallest;
    }
    
    public static String smallest(String num) {
        String smallest = null;
        //for (int i = 0; i < num.length(); i++) {
            StringBuilder builder = new StringBuilder();
            boolean allSame = true;
            for (int j = 1; j < num.length(); j++) {
                if (num.charAt(j-1) > num.charAt(j)) {
                	builder.append(num.substring(0, j-1));
                	builder.append(num.substring(j));
                	smallest = builder.toString();
                	break;
                } 
                if (num.charAt(j-1) == num.charAt(j)) {
                	allSame = allSame & true;
                }
                /*else if (num.charAt(j-1) < num.charAt(j)) {
                	builder.append(num.substring(0, j));
                	builder.append(num.substring(j+1));
                	smallest = builder.toString();
                	break;
                }*/
            }
            
            if (smallest == null) {
            	// all the numbers are equal
            	if (allSame) {
            		smallest = num.substring(0, num.length() - 2);
            	} else {
            		// all the numbers are in ascensing order
            		smallest = num.substring(1);
            	}
            }
        //}
        while (smallest.startsWith("0")) {
        	smallest = smallest.substring(1);
        }
        return smallest;
    }
}
