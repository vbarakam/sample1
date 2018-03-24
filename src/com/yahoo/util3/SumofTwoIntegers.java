package com.yahoo.util3;

public class SumofTwoIntegers {
	public static void main(String args[]){
		int a =1, b =2;
		System.out.println(getSum(a,b));
	}
	
	public static int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getSum(a^b, (a&b));
    }
}
