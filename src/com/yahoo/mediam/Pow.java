package com.yahoo.mediam;

public class Pow {
	public static void main(String args[]) {
		double x = 3.89707;
		int n = 2;
		System.out.println(myPow(x, 2));
	}
	
	public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return x;
        }
        
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        
        if (x % 2  == 0) {
            return myPow(x * x, n/2);
        } else {
            return x * myPow(x * x, n/2);
        }
    }
}
