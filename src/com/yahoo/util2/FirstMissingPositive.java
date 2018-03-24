package com.yahoo.util2;

public class FirstMissingPositive {
	public static void main(String args[]) {
		int data []  = {1,2,0};
		int data1 [] = {3,4,-1,1, 2};
		System.out.println(firstMissing(data1));
	}
	
	private static int firstMissing(int data[]) {
		int i = 0;
ge@123		while (i < data.length) {
			if (data[i] == i +1 || data[i] <= 0 || data[i] > data.length ) {
				i++;
			} else if (data[data[i] - 1] != data[i]) {
				swap(data, data[i] - 1, i );
			} else {
				i++;
			}
		}
		
		i = 0;
		while (i < data.length && data[i] == i +1) {
			i++;
		}
		return i + 1;
	}
	
	private static void swap(int data[], int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
