package com.yahoo.util;

import java.util.Stack;

class MinStack {
    int min;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
    
    public static void main(String arg[]) {
    	//10, 5,
    	MinStack stack = new MinStack();
    	stack.push(10);
    	stack.push(5);
    	//10, 5, 0, -1,0,-1,0
    	stack.push(0);
    	stack.push(-1);
    	stack.push(0);
    	stack.push(-1);
    	System.out.println("+");
    	System.out.println(Long.lowestOneBit(4L));
    }
}