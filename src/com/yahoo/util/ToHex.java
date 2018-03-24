package com.yahoo.util;

import java.util.*;

public class ToHex {
	
	public static void main(String args[]) {
		Map<Integer, String> mapping = new HashMap<>();
		mapping.put(10, "a");
		mapping.put(11, "b");
		mapping.put(12, "c");
		mapping.put(13, "d");
		mapping.put(14, "e");
		mapping.put(15, "f");
		//System.out.println(toHex(1000000000, mapping));
		    
		int nums1[] = {124,  98,  124, 23,98, 124, 98};
			int nums3[] = {1, 2, 1, 3, 5, 2};
		singleNumber2(nums3);
	}
	
	public static int[] singleNumber2(int[] nums) {
		int result = nums[0];
		int result2 = nums[0];
		for (int j = 1; j < nums.length; j++) {
			System.out.println(nums[j] + " " + Integer.toBinaryString(nums[j]));
			result = result ^ nums[j];
			result2 = result2 & nums[j];
		}
		
		System.out.println(" r 2" + result2);
		
		int temp = result;
		System.out.println(result + " result " + Integer.toBinaryString(result));
		System.out.println((result &= -result) + " result " + Integer.toBinaryString(result &= -result));
    	System.out.println(temp);
		for (int j = 0; j < nums.length; j++) {
			int result32 = temp ^ nums[j];
			System.out.println(nums[j] + " ==> " + result32 );
			temp = result32;
		}
		
		return new int[0];
    }
	public static int singleNumber(int[] nums) {
	       int result = 0;
	       for (int i = 10; i >= 0; i--) {
	           int sum = 0;
	           for (int j = 0; j < nums.length; j++) {
	               if ((nums[j] >> i & 1) == 1) {
	                   sum++;
	               }
	           }
	           result <<= 1;
	           result |= sum % 3 == 0 ? 0 : 1;
	       }
	       return result;
	    }
	
	 public static String decimal2Hex(int d) {
	        String digits = "0123456789ABCDEF";
	        if (d == 0) return "0";
	        String hex = "";
	        while (d > 0) {
	            int digit = d % 16;                // rightmost digit
	            hex = digits.charAt(digit) + hex;  // string concatenation
	            d = d / 16;
	        }
	        return hex;
	    }

	
	public static String toHex(int num, Map<Integer, String> mapping) {
		System.out.println(Integer.toHexString(num));
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(0xff));
		String parts [] = new String[4];
		int partNum = 3;
		for (int i = 0; i < 32; i=i+8) {
			int bits = num & 0xff;
			num = num >> 8;
			//if (bits == 0) {
			//	continue;
			//}
			StringBuilder sbPart = new StringBuilder();
			while (bits != 0) {
				int b = bits % 16;
				if (mapping.containsKey(b)) {
					sbPart.append(mapping.get(b));
				} else {
					sbPart.append(b);
				}
				bits = bits/16;
			}
			if (sbPart.length() < 2) {
				while (sbPart.length() < 2) {
					sbPart.append("0");
				}
			}
			parts[partNum--] = sbPart.reverse().toString();
		}
		StringBuilder sb = new StringBuilder();
		for (String part : parts) {
			if (part != null) {
				sb.append(part);
			}
		}
		return sb.toString().startsWith("0") ? sb.toString().substring(1) :  sb.toString();
	}
}
