package com.yahoo.util2;

public class JumpGame {
	public static void main(String args[]) {
		int num1[] = { 2, 3, 1, 1, 4 };
		int num2[] = { 3, 2, 1, 0, 4 };
		System.out.println(canJump(num2));
	}

	public static boolean canJump(int[] nums) {
		int j = 0;
		int index = 0;
		for (; j < nums.length && index <= nums.length;) {
			index++;
			j += nums[j];
			if (j == nums.length - 1) {
				return true;
			}
		}
		return false;
	}
}
