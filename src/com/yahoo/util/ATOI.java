package com.yahoo.util;

public class ATOI {
	public static void main(String args[]) {
		//-2147483649
		//2147483648
		/*System.out.println(myAtoi2("-2147483648"));
		System.out.println("Max Value " + Integer.MAX_VALUE);
		System.out.println("Min Value " + Integer.MIN_VALUE);*/
		int data [] = {4, 5, 6, 7, 0, 1, 2};
		search2(data, 1, 0, data.length-1);
		/*System.out.println(myAtoi("  -0012a42"));
		System.out.println(myAtoi("  0012a42"));
		System.out.println(myAtoi("  +0012a42"));
		System.out.println(myAtoi("  +123"));*/
	}
	
	
	private static void search2(int[] nums, int target, int start, int end) {
        int low = start, high = end;
        while (low < high) {
            int mid = (low + high)/2;
            if (nums[mid] > nums[high]) {
                low =  mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(" low " + low);
    }
	
	public static int myAtoi2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        String temp = str.trim();
        int sign = 1;
        long num = 0;
        int i = 0;
        if (temp.startsWith("-")) {
            sign = -1;
            i = 1;
        } else if (temp.startsWith("+")) {
            i = 1;
        }
        for (; i < temp.length(); i++) {
            if (!(temp.charAt(i) >= '0' && temp.charAt(i)  <= '9')) {
                return (int) (sign * num);
            }
            num = num * 10 + temp.charAt(i) - '0';
            System.out.println(Integer.MIN_VALUE);
            System.out.println((sign * num));
            if ((sign == 1 && num > Integer.MAX_VALUE) || (sign == -1 && (sign * num) < Integer.MIN_VALUE)) {
                return 0;
            }
        }
        return (int) (sign * num);
    }
	
	public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        
        
        int i = 0;

        // first check if it's negative
        boolean negative = false;
        
        if (str.charAt(0) == '-') {
            negative = true;
        } 
        
        // read each char from left and
        int start = negative? 1 : (str.charAt(0) == '+' ? 1 : 0);
        int l = negative? str.length() -1 : str.length()-1;
        
        // -123 or 123
        for (int k = start; k < str.length(); k++) {
            if (str.charAt(k) >= '0' && str.charAt(k) <= '9') {
                int temp = str.charAt(k) - '0';
                //int value = (int) (temp * Math.pow(10,l-k));
                i = i * 10 + temp;
            } else {
                //i = (int) (i/Math.pow(10,str.length()-k));
                return negative ? (-1 * i) : i;
            }
        }
        
        System.out.println("MIN :: " + (i <= Integer.MIN_VALUE));
        System.out.println("MAX :: " + (i < Integer.MAX_VALUE));
        
        System.out.println("i :: " + i);
        
        i = i > Integer.MAX_VALUE || i <= Integer.MIN_VALUE ? negative ? Integer.MIN_VALUE : Integer.MAX_VALUE : i;
        
        System.out.println("i :: " + i);
        return negative ? (-1 * i) : i;
    }
}
