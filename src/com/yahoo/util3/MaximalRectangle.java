package com.yahoo.util3;

import java.util.*;

public class MaximalRectangle {
	public static void main(String args[]) {
		int heights[] = {1, 1};
		System.out.println(area(heights));
	}
	
	public static int area(int [] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int tp = stack.pop();
                max = Math.max(max, heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }
        return max;
    }
}
