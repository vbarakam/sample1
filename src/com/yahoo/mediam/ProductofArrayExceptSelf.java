package com.yahoo.mediam;

public class ProductofArrayExceptSelf {
	public static void main(String args[]) {
		int nums[] = { 1, 2, 3, 4 };
		int res[] = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i< res.length;i++) {
			res[i] = res[i-1] * nums[i-1];
		}
		int right = 1;
		for (int i = res.length -1; i>=0; i--) {
			res[i] = res[i] * right;
			right *= nums[i];
		}
		
	}
}
