package com.yahoo.util2;

public class ClimbingStairs {
	public static void main(String args[]) {
		
	}
	
	public int climbStairs(int n) {
        // base cases
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
    
        int cache [] = new int[n];
        cache[0] = 1;
        cache[1] = 2;
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n-1];
    }
}
