package com.yahoo.util;

public class MaxProduct {

	public static void main(String args[]) {
		int a[] = {1,0,-1,2,3,-5,-2};
		//[-2,0,-1]
		System.out.println(maxProduct(a));
	}
	
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int [] m = new int[nums.length];
        m[0] = nums[0];
         int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
		    max = nums[i] > max ? nums[i] : max;
		    if (nums[i] == 0 || m[i-1] == 0) {
		        continue;
		    }
		    m[i] = (nums[i] == 0 ? 1 : nums[i]) * m[i-1];
		    max = m[i] > max ? m[i] : max;
		}

       
        for (int i = 0; i < nums.length; i++) {
            max = m[i] > max ? m[i] : max; 
            if ( m[i] == 0) {
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                int num = m[j]/m[i];
                max = num > max ? num : max; 
            }
        }

		return max;
	
    }
}
