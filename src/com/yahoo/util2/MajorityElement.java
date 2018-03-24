package com.yahoo.util2;

public class MajorityElement {
	public static void main(String args[]) {
		int data[] = {6,5,5};
		majorityElement(data);
	}
	
	public static int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int cnt = 1;
        int num = nums[0];
        //[6,5,5]
        for (int num2 : nums) {
            if (cnt == 0) {
                cnt++;
                num = num2;
            } else if (num == num2) {
                cnt++;
            } else {
                cnt--;
            }
        }
        
        return num;
    }
}
