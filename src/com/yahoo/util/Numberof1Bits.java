package com.yahoo.util;

public class Numberof1Bits {
	public static void main(String args) {
		Integer n =  2147483647;
	}
	
	public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
        	System.out.println(n);
            count += (n & 1); 
            n = n >>> 1;
        }
        return count;
    }
}
