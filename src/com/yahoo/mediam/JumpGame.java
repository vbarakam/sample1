package com.yahoo.mediam;

public class JumpGame {
	public static void main(String args[]) {
		int data [] = {2,3,1,1,4};
		canJump(data);
	}
	
	public static boolean canJump(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > index) {
                return false;
            }
            index = Math.max(index, nums[i] + i);
        }
        
        return true;
    }

}
