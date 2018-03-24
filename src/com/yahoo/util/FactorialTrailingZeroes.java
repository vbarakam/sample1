package com.yahoo.util;

public class FactorialTrailingZeroes {
	public static void main(String args[]) {
		System.out.println(trailingZeroes(0));
		System.out.println(trailingZeroes(2));
		System.out.println(trailingZeroes(3));
		System.out.println(trailingZeroes(4));
		System.out.println(trailingZeroes(5));
		System.out.println(trailingZeroes(6));
		System.out.println(trailingZeroes(7));
		System.out.println(trailingZeroes(8));
		System.out.println(trailingZeroes(9));
		System.out.println(trailingZeroes(10));
		System.out.println(trailingZeroes(125));
	}
	
	public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }
}
