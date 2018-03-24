package com.yahoo.util.sorting;

public class StackImpl {

	public static void main(String args[]) {
		Stack stack = new Stack(3);
		System.out.println(" Empty :: " + stack.pop());
		stack.print();
		stack.push(10);
		stack.print();
		stack.pop();
		stack.print();
		stack.push(20);
		stack.print();
		stack.push(30);
		stack.print();
		stack.push(40);
		stack.print();
		stack.pop();
		stack.print();
		
	}
	
	static class Stack {
		int values [] = null;
		int top = -1;
		
		public Stack(int size) {
			values = new int[size];
		}
		
		public void push(int value) {
			if (top > values.length) {
			}
			top = top+1;
			values[top] = value;
		}
		
		public int pop() {
			if (top == -1)
				return -1;
			else {
				top = top -1;
				return values[top+1];
			}
				
		}
		
		public void print() {
			for (int i =0; i<= top; i++) {
				System.out.print( values[i] + " ");
			}
			System.out.println();
		}
	}
}
