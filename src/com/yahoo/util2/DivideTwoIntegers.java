package com.yahoo.util2;

public class DivideTwoIntegers {
	public static void main(String args[]) {
		System.out.println(divide2(-1, -1));
	}
	
	
	 public static int divide2(int dividend, int divisor) {
	        if (divisor == 0) {
	            return Integer.MAX_VALUE;
	        }
	        
	        int sign = 1;
	        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
	            dividend = Math.abs(dividend);
	            divisor = Math.abs(divisor);
	            sign = -1;
	        }
	        
	        if (dividend < divisor) {
	            return 0;
	        }
	        
	        long count = ldivide2(dividend, divisor);
	        if  (count >= Integer.MAX_VALUE) {
	                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	            }

	        return (int)(sign * count);
	    }
	    
	    private static long ldivide2(long dividend, long divisor) {
	        if (dividend < divisor) {
	            return 0;
	        }
	        long sum = divisor;
	        long count = 1;
	        while (sum + sum < dividend) {
	            sum += sum;
	            count += count;
	        }
	        return count + ldivide(dividend-sum, divisor);
	    }
	
	public static int divide(int dividend, int divisor) {
        
		if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        int sign = 1;
        if (dividend < 0 ^ divisor < 0) {
            sign = -1;
        }
        
        long ldividend = Math.abs((long)dividend); 
        long ldivisor = Math.abs((long)divisor);
        
        if (ldividend == 0 || ldividend < ldivisor) {
            return 0;
        }
        
        long val = ldivide(ldividend, ldivisor);
        if  (val >= Integer.MAX_VALUE) {
            return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) val * sign;
    }
    
    private static long ldivide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        
        long sum = divisor;
        long mul = 1;
        while (sum+sum < dividend) {
           sum += sum;
           mul += mul;
        }
        return mul + ldivide(dividend - sum,  divisor);
    }
}
