package com.yahoo.util;

public class PowerOfThree {

	public static void main(String args[]) {
		int f =  0x55555555;
		int f2 = 0x7FFFFFFF;
		System.out.println(f);
		System.out.println(f2);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(f));
		System.out.println(Integer.toHexString(Integer.MAX_VALUE));
		System.out.println(isPowerOfThree(27));
	}
	
	//27
	//6
	//1
	public static boolean isPowerOfThree(int n) {
		int value = (int) Math.pow(3, 19);
		return ((n > 0) && ( value % n == 0));
	}
	
	public static boolean isPowerOfThree1(int n) {
		int value = 0;
		while (n > 0 && n != 3) {
			value = Math.max((n % 3), value);
			n = n / 3;
		}

		return value == 0 ? true : false;
	}
}
