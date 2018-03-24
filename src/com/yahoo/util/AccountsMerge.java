package com.yahoo.util;

import java.util.*;

public class AccountsMerge {
	public static void main(String args[]) {
		int nums[] = {1,2,1,2,6,7,5,1};
		maxSumOfThreeSubarrays(nums, 2);
	}
	
	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sums[] = new int[nums.length-k+1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i-k >= 0) {
                sum -= nums[i-k];
            }
            if (i-k+1 >= 0) {
                sums[i-k+1] = sum;
            }
        }
        int left[] = new int[sums.length];
        int best = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[best]) {
                best = i;
            }
            left[i] = best;
        }
        
        int right[] = new int[sums.length];
        best = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[best]) {
                best = i;
            }
            right[i] = best;
        }
        int ans[] = {-1,-1,-1};
        for (int i = k; i < sums.length -k; i++) {
            int j = left[i-k];
            int l = right[i+k];
            if (ans[0] == -1 || (sums[i] + sums[j] + sums[l]) > (sums[ans[0]] + sums[ans[1]] + sums[ans[2]])) {
                ans[0] = j;
                ans[1] = i;
                ans[2] = l;
            }
        }
        return ans;
    }


}

class DSU {
	int[] parent;

	public DSU() {
		parent = new int[10001];
		for (int i = 0; i < 10001; i++) {
			parent[i] = i;
		}
	}

	public int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public void union(int x, int y) {
		parent[find(x)] = find(y);
	}
}
