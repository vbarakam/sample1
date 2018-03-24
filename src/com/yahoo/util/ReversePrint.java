package com.yahoo.util;

public class ReversePrint {
	public static void main (String args[]) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(reverse(1534236469));
	}
	
	public static int reverse(int x) {
        //123
        int negative = 1;
        if (x < 0) {
            negative = -1;
            x = x * negative;
        }
        
        long sum = 0;
        while (x > 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
            System.out.println(sum);
        }
        
        if (sum > Integer.MAX_VALUE) {
        	return 0;
        } else {
        	return (int) sum * negative;
        }
    }
}
