package com.yahoo.util.sorting;

import java.util.Arrays;

public class CountingSort {

	public static void main(String args[]) {
		int a[] = { 3,1,5,8 };
		System.out.println(maxCoins(a));
	}

	public static int maxCoins(int[] nums) {
        int n = nums.length;
        int temp[] = new int[n+2];
        int index = 1;
        for (int num : nums) {
            temp[index++] = num;
        }
        temp[0] = temp[n+1] = 1;
        n += 2;
        int dp[][] = new int[n][n];
        for (int len = 2; len<= n; len++ ) {
            for (int left = 0; left < n - len; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][k] + dp[k][right] + temp[left]*temp[k]*temp[right]); 
                }
            }
        }
        return dp[0][n-1];
    }
	
	private static int[] sort4(int nums[], int max) {
		int counts[] = new int[max];
		int result[] = new int[nums.length];
		for (int num : nums) {
			counts[num]++;
		}
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i-1];
		}
		for (int num : nums) {
			result[counts[num]-1] = num;
			counts[num]--;
		}
		return result;
	}

	public static int[] sort(int[] arr, int max) {
		int nums[] = new int[max];
		for (int a : arr) {
			nums[a]++;
		}
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + nums[i-1];
		}
		int results[] = new int[arr.length];
		for (int a : arr) {
			results[nums[a]-1] = a;
			nums[a]--;
		}
		return results;
	}

	public static int[] sort3(int[] arr, int max) {
		int b[] = new int[arr.length];
		int temp[] = new int[max];
		for (int val : arr) {
			temp[val] += 1;
		}
		System.out.println(Arrays.toString(temp));
		for (int i = 1; i < temp.length; i++) {
			temp[i] += temp[i - 1];
		}
		System.out.println(Arrays.toString(temp));
		for (int i : arr) {
			b[temp[i] - 1] = i;
			temp[i] -= 1;
		}
		System.out.println(Arrays.toString(b));
		/*
		 * int count = 0; for (int index = 0; index < temp.length; index++) {
		 * for (int j = 0; j < temp[index]; j++) { b[count++] = index; } }
		 */
		return b;
	}

	public static int[] sort2(int[] arr, int max) {
		int b[] = new int[arr.length];
		int temp[] = new int[max];
		for (int val : arr) {
			temp[val] += 1;
		}
		System.out.println(Arrays.toString(temp));
		int count = 0;
		for (int index = 0; index < temp.length; index++) {
			for (int j = 0; j < temp[index]; j++) {
				b[count++] = index;
			}
		}
		return b;
	}
}
