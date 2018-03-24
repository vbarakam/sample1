package com.yahoo.util;

public class CountBits {

	public static void main(String args[]) {
		int i = 999;
		//System.out.println(i);
		for (int j = i; j > 0;) {
			j = j >> 1;
			System.out.println(j);
		}
	}
	public static void main3d(String args[]) {
		int n = 1000;
		int r [] = numArray(3, 4);
		for (int f : r) {
			System.out.print(f);
		}
		r = complimentNumArray(r);
		System.out.println();
		for (int f : r) {
			System.out.print(f);
		}
	}
	
	public static int[] numArray(int i, int s) {
        int [] result = new int[s];
        s = s - 1;
        while (i > 0) {
            result[s--] = i % 2;
            i = i / 2;
        }
        
        return result;
    }
	
	
	public static int[] complimentNumArray(int set1 []) {
        int [] result = new int[set1.length];
        for (int i = 0; i < set1.length; i++) {
            if (set1[i] == 0) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
	
	public static int[] countBits(int num) {
        int result [] = new int[num] ;
        
        if (num == 0) {
            return result;    
        }
        
        if (num >= 2) {
        	result[1] = 1;
        }
        
        int exp = 1;
        int pow = 2;
        for (int i = 2; i < num; i++) {
            if (i == Math.pow(2,exp+1)) {
                pow = (int) Math.pow(2,exp+1);
                exp = exp + 1;
            }
            result [i] = 1 + result [i-pow];
        }
        
        return result;
    }
}
