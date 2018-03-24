package com.yahoo.util;

public class ReverseBits {

	public static void main(String args[]) {
		System.out.println(reverseBits(1));
	}
	
	public static int reverseBits(int n) {
        int result = 0;
        int index = 0;
        while (index < 32) {
            result <<= 1;
            if ((n & 1) == 1) {
                result = result | 1;
            }
            n >>>= 1;
        }
        return result;
    }
}
