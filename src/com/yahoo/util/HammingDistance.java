package com.yahoo.util;

public class HammingDistance {
	public static void main(String args[]) {
		int d[] = {4,14,2};
		//System.out.println(totalHammingDistance(d));
		System.out.println(hammingDistance(1, 4));
	}

	public static int totalHammingDistance(int[] nums) {
        int diff = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0; j < nums.length; j++) {
                bitCount = bitCount + ((nums[j] >> i) & 1);
            }
            diff = diff + bitCount * (nums.length - bitCount);
        }
        return diff;
    }
	
	public static int hammingDistance(int x, int y) {
        int z = x^y;
        int count = 0;
        while(z != 0) {
            count = count + (z & 1);
            z = z >>> 1;
        }
        return count;
    }
	
public static int hammingDistance2(int x, int y) {
        
	    int diff = 0;
        int r = x ^ y;
        String xBinary = Integer.toBinaryString(r);
        for (char c : xBinary.toCharArray()) {
        	if (c == '1') {
        		diff++;
        	}
        }
        /*
		// get the binary equivalent for x and y
        String xBinary = Integer.toBinaryString(x);
        String yBinary = Integer.toBinaryString(y);
        
        // size of x and y can be different, take the smaller and add different in size as difference
        int diff = Math.abs(xBinary.length() - yBinary.length());
        if (diff > 0) {
             // pad y
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < diff; i++) {
                sb.append("0");
            }
            if (xBinary.length() > yBinary.length()) {
                sb.append(yBinary);
                yBinary = sb.toString();
            } else {
                // pad 
                sb.append(xBinary);
                xBinary = sb.toString();
            }
        }
        diff = 0;
        for (int index = 0; index < xBinary.length(); index++) {
            if (xBinary.charAt(index) != yBinary.charAt(index)) {
                diff++;
            }
        }*/
        
        return diff;
    }
}
