package com.yahoo.util.sorting;

public class InsertionSort {
	public static void main(String [] args) {
		int A[] = {5,2,4,6,1,3};
		//int A[] = {5,1,4,6,1,1};
		//int A[] = {9,8,7,6,5,4,3,2,1,11,11,1};
		sort(A);
		for (int i =0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
	
	private static void sort2(int [] s) {
		// 5,2,4,6,1,3
		// 2,5,4,6,1,3
		for (int i = 1; i < s.length;i++) {
			int temp = i-1;
			while (temp >= 0) {
				if (s[i] < s[temp] && (temp-1 < 0 || s[i] >= s[temp-1])) {
					int temp2 = s[temp];
					s[temp] = s[i];
					while (temp != i) {
						temp = temp + 1;

						if (temp > s.length) {
							break;
						}
						int temp3 = s[temp];
						s[temp] = temp2;
						temp2 = temp3;
					}
					break;
				}
				temp = temp - 1;
			}
			for (int j =0; j < s.length; j++) {
				System.out.print(s[j] + " ");
			}
			System.out.println();

		}
	}
	
	private static void sort(int [] data) {
		// 5,2,4,6,1,3
		// 2,5,4,6,1,3
		for (int i = 1; i < data.length; i++) {
			int value = data[i];
			int index = i - 1;
			while (index >= 0 && value < data[index]) {
				data[index + 1] = data[index];
				index--;
			}
			data[index + 1] = value;
		}
	}
}
