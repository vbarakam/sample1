package com.yahoo.util;

public class RotateNumber {
	public static void main(String args[]) {
		//4 5 6 7 0 1 2
		int array [] = {6,7,0,1,2,4,5};
		
		for (int index = 0;  index < array.length ; index++) {
			int i = (2 + index ) % array.length;
			System.out.print(" " + array[i]);
		}
		
	}
}
