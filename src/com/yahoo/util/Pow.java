package com.yahoo.util;

public class Pow {
	public static void main(String args[]) {
		System.out.println(myPow(2.00000, -2147483648));
	}
	
	public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1/x;
            n = -n;
        }

        return n % 2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}
