package com.yahoo.util;

public class HappyNumber {
	public static void main(String args[]) {
		System.out.println(isHappy(2));
	}
	
	public static boolean isHappy(int n) {
		Set<Integer> inLoop = new HashSet<Integer>();
        if (n == 1) {
            return true;
        }
            
        while (n > 0) {
            // inner loop to calculate sum
            int sum = 0;
            while (n > 0) {
                sum += Math.pow((n%10),2);
                n = n/10;
            }
            // check if sum == 1
            if (sum == 1) {
                return true;
            }
            n = sum;
            System.out.println(n);
        }
        
        return false;
    }
}
