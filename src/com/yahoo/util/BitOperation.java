package com.yahoo.util;

public class BitOperation {

	static int binaryToInt(String binary) {
		char[] cA = binary.toCharArray();
		int result = 0;
		for (int i = cA.length - 1; i >= 0; i--) {
			// 111 , length = 3, i = 2, 2^(3-3) + 2^(3-2)
			// 0 1
			if (cA[i] == '1')
				result += Math.pow(2, cA.length - i - 1);
		}
		return result;
	}
	
	public static void main(String args[]) {
		System.out.println(Integer.toBinaryString(26));
		long i = 2147483648L;
	
		long bits[] = new long[32];
		int index = 31;
		while (i != 0) {
			bits[index--] = i % 2;
			i = i /2;
		}
		
		for (long b : bits) {
			System.out.print(b);
		}
		System.out.println();
		long result = 0;
        for (int j = 0; j < 32; j++) {
            result = result + bits[j] * (long) Math.pow(2, j);
        }
        
        System.out.println(result);
	}

	public static void main2(String args[]) {

		int n0 = 13;

		

		System.out.println(n0 & 30);
		// 23 (00-01-01-11)
		// 43 (00-10-10-11)
		int n = 23;
		int even = 0xAAAAAAAA;
		int odd = 0x55555555;

		int evenA = n & even;
		int oddA = n & odd;
		evenA = evenA >> 1;
		oddA = oddA << 1;
		int n2 = evenA | oddA;
		System.out.println(n2);
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(n2));
		/*
		 * int mask = 1 << 3; System.out.println(Integer.toBinaryString(mask));
		 * System.out.println(Integer.toBinaryString(~mask));
		 * System.out.println(Integer.toBinaryString(val & ~mask));
		 * System.out.println(Integer.toBinaryString(val ^ mask));
		 * 
		 * val = 17; System.out.println(val);
		 * System.out.println(Integer.toBinaryString(val)); mask = 1 << 3;
		 * System.out.println(Integer.toBinaryString(mask));
		 * System.out.println(Integer.toBinaryString(~mask));
		 * System.out.println(Integer.toBinaryString(val & ~mask));
		 * System.out.println(Integer.toBinaryString(val ^ mask));
		 * 
		 * //System.out.println(binaryToInt(Integer.toBinaryString(val << 32)));
		 * 
		 * /*System.out.println(Integer.toBinaryString(val)); int val2 =
		 * val>>>1; System.out.println(val2);
		 * System.out.println(Integer.toBinaryString(val>>>1)); int val3 =
		 * val>>1; System.out.println(val3);
		 * System.out.println(Integer.toBinaryString(val>>1));
		 */
		/*
		 * System.out.println(">>" + (val >> 1)); System.out.println("<<" + (val
		 * << 1)); System.out.println(val >>> 1); Integer val2 = 75;
		 * System.out.println(Integer.toBinaryString(val2));
		 * System.out.println(Integer.toBinaryString(val2 >> 1));
		 * System.out.println(">>" + (val2 >> 1));
		 * System.out.println(Integer.toBinaryString(val2 << 1));
		 * System.out.println("<<" + (val2 << 1)); System.out.println(val2 >>>
		 * 1);
		 */

	}
}
