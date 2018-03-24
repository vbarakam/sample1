package com.yahoo.util2;

import java.util.*;

public class LargestRectangleinHistogram {
	public static void main(String args[]) {
		int data [] = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(data));
	}
	
	public static int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int hx = (i == heights.length) ? 0 : heights[i]; 
            if ((stack.isEmpty() || hx >= heights[stack.peek()]) ){
                stack.push(i);
            } else {
                int j = stack.pop();
                max = Math.max(max, heights[j] * (i - j));
                i--;
            }
        }
        return max;
    }
}
