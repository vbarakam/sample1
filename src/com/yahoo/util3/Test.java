package com.yahoo.util3;

import java.util.*;

public class Test {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String args[]) {
		String str1 = "hello";
		String str2= "ooolleoooleh";
		checkInclusion(str1, str2);
	}
	
	public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int counts[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)-'a']++;
            counts[s2.charAt(i)-'a']--;
        }
        
        if (allZeros(counts)) {
            return true;
        }
        int len = s1.length();
        for (int i = s1.length(); i < s2.length(); i++) {
            counts[s2.charAt(i)-'a']--;
            counts[s2.charAt(i-len)-'a']++;
            if (allZeros(counts)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean allZeros(int counts[]) {
        int sum = 0;
        for (int count : counts) {
            sum += count;
        }
        return sum == 0 ? true: false;
    }

	private static int lcs(String str1, String str2) {
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}

	public static int longestConsecutive(int[] nums) {
		int max = 0;
		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!cache.containsKey(nums[i])) {
				int right = cache.getOrDefault(nums[i] + 1, 0);
				int left = cache.getOrDefault(nums[i] - 1, 0);
				int sum = right + left + 1;
				max = Math.max(max, sum);
				cache.put(nums[i], sum);
				cache.put(nums[i] - left, sum);
				cache.put(nums[i] + right, sum);
			}
		}
		return max;
	}

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int max = 0;
		int cache[][] = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				process(matrix, cache, i, j);
				max = Math.max(max, cache[i][j]);
			}
		}
		return max;
	}

	private static int process(int[][] matrix, int cache[][], int i, int j) {
		if (cache[i][j] != 0) {
			return cache[i][j];
		}

		if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
			cache[i][j] = Math.max(cache[i][j], process(matrix, cache, i - 1, j));
		}

		if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
			cache[i][j] = Math.max(cache[i][j], process(matrix, cache, i + 1, j));
		}

		if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
			cache[i][j] = Math.max(cache[i][j], process(matrix, cache, i, j - 1));
		}

		if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
			cache[i][j] = Math.max(cache[i][j], process(matrix, cache, i, j + 1));
		}

		return ++cache[i][j];
	}

	public static int maxProfit(int[] prices) {
		int prev_buy = 0, buy = Integer.MIN_VALUE, prev_sell = 0, sell = 0;
		for (int i = 0; i < prices.length; i++) {
			System.out.println("prev_buy " + prev_buy);
			System.out.println("buy " + buy);
			System.out.println("prev_sell " + prev_sell);
			System.out.println("sell " + sell);

			prev_buy = buy;
			buy = Math.max(prev_sell - prices[i], prev_buy);
			prev_sell = sell;
			sell = Math.max(prev_buy + prices[i], prev_sell);

			System.out.println("prev_buy " + prev_buy);
			System.out.println("buy " + buy);
			System.out.println("prev_sell " + prev_sell);
			System.out.println("sell " + sell);
		}
		return sell;
	}

	public static int calculate(String s) {
		if (s.length() == 0) {
			return 0;
		}
		// (1+(4+5+2)-3)+(6+8)
		// 0,1,1,1
		int result = 0;
		int num = 0;
		int sign = 1;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				num = num * 10 + (ch - '0');
			} else if (ch == '+' || ch == '-' || ch == '(' || ch == ')' || i == s.length() - 1) {
				if (ch == '+') {
					result += sign * num;
					sign = 1;
				} else if (ch == '-') {
					result += sign * num;
					sign = -1;
				} else if (ch == '(') {
					stack.push(result);
					stack.push(sign);
					sign = 1;
					result = 0;
				} else if (ch == ')') {
					result += sign * num;
					result *= stack.pop();
					result += stack.pop();
					sign = 1;
				}
				num = 0;
			}
		}
		if (num != 0) {
			result += sign * num;
		}
		return result;
	}

	public static int numSquares1(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			int j = 1;
			int min = Integer.MAX_VALUE;
			while (j * j <= i) {
				min = Math.min(min, dp[i - j * j] + 1);
				j++;
			}
			dp[i] = min;
		}
		return dp[n];
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer> edges[] = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		for (int edge[] : prerequisites) {
			edges[edge[1]].add(edge[0]);
		}
		Queue<Integer> leafs = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (edges[i].size() == 0) {
				leafs.add(i);
			}
		}
		int[] results = new int[numCourses];
		int index = 0;
		while (!leafs.isEmpty()) {
			Integer leaf = leafs.poll();
			results[index++] = leaf;
			for (int i = 0; i < numCourses; i++) {
				if (edges[i].size() == 0) {
					continue;
				}
				if (edges[i].contains(leaf)) {
					edges[i].remove((Integer) leaf);
					if (edges[i].size() == 0) {
						leafs.add(i);
					}
				}
			}
		}
		return results;
	}

	public static void sortColors(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int left = 0;
		while (left < nums.length && nums[left] == 0) {
			left++;
		}
		int right = nums.length - 1;
		while (right > left && nums[right] == 2) {
			right--;
		}

		for (int i = left; i <= right; i++) {
			while (nums[i] == 2 && right > left) {
				int temp = nums[right];
				nums[right] = nums[i];
				nums[i] = temp;
				right--;
			}

			while (nums[i] == 0 && left < right) {
				int temp = nums[left];
				nums[left] = nums[i];
				nums[i] = temp;
				left++;
			}
		}
	}

	public static boolean canJump(int[] nums) {
		int reachable = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > reachable) {
				return false;
			}
			reachable = Math.max(reachable, i + nums[i]);
		}
		return true;
	}

	public static int findKthLargest(int[] nums, int k) {
		int start = 0, end = nums.length - 1;
		k = k - 1;
		while (start <= end) {
			int p = pivot(nums, start, end);
			if (p == k) {
				return nums[p];
			} else if (k > p) {
				start = p + 1;
			} else {
				end = p - 1;
			}
		}
		return -1;
	}

	private static int pivot(int[] nums, int start, int end) {
		int pivot = nums[end];
		int j = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) {
				swap(nums, i, j);
				j++;
			}
		}
		swap(nums, end, j);
		return j;
	}

	private static void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> results = new ArrayList<>();
		factors(n, results, new ArrayList<Integer>(), 2);
		return results;
	}

	public static int lengthOfLongestSubstring(String str) {
		int start = 0, end = 0, n = str.length();
		int counts[] = new int[256];
		int max = Integer.MIN_VALUE;
		boolean flag = false;
		for (char ch : str.toCharArray()) {
			if (counts[ch]++ > 0) {
				flag = true;
			}
			end++;
			while (flag) {
				if (str.charAt(start) == ch) {
					flag = false;
				}
				counts[str.charAt(start)]--;
				start++;
			}
			max = Math.max(max, end - start);
		}
		return max != Integer.MIN_VALUE ? max : 0;
	}

	public static int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char ch : tasks) {
			map[ch - 'A']++;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(26, Collections.reverseOrder());
		for (int f : map) {
			if (f > 0) {
				queue.add(f);
			}
		}
		int time = 0;
		while (!queue.isEmpty()) {
			int i = 0;
			List<Integer> temp = new ArrayList<>();
			while (i < n) {
				if (queue.peek() - 1 > 0) {
					temp.add(queue.poll() - 1);
				} else {
					queue.poll();
				}
				time++;

				if (queue.isEmpty() && temp.size() == 0)
					break;
				i++;
			}
			queue.addAll(temp);
		}
		return time;
	}

	public static int findNumberOfLIS2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int counts[] = new int[nums.length];
		int lengths[] = new int[nums.length];
		Arrays.fill(counts, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					if (lengths[j] >= lengths[i]) {
						lengths[i] = lengths[j] + 1;
						counts[i] = counts[j];
					} else if (lengths[j] + 1 == lengths[i]) {
						counts[i] += counts[j];
					}
				}
			}
		}
		int max = 0;
		for (int length : lengths) {
			max = Math.max(length, max);
		}
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (max == lengths[i]) {
				cnt += counts[i];
			}
		}
		return cnt;
	}

	private static void factors(int n, List<List<Integer>> results, List<Integer> result, int start) {
		if (n <= 1) {
			results.add(new ArrayList<Integer>(result));
			return;
		}

		for (int i = start; i <= n; i++) {
			if (n % i == 0) {
				result.add(i);
				factors(n / i, results, result, start);
				result.remove(result.size() - 1);
			}
		}
	}

	public static List<Integer> dis(int nums[]) {
		int j = 0, n = nums.length;
		while (j < n) {
			if (nums[j] == j + 1) {
				j++;
			} else if (nums[nums[j] - 1] != nums[j]) {
				int temp = nums[nums[j] - 1];
				nums[nums[j] - 1] = nums[j];
				nums[j] = temp;
			} else {
				j++;
			}
		}
		j = 0;
		List<Integer> results = new ArrayList<>();
		while (j < n) {
			if (nums[j] != j + 1) {
				results.add(j + 1);
			}
			j++;
		}
		return results;
	}

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int indexA = a.length() - 1;
		int indexB = b.length() - 1;
		while (indexA >= 0 && indexB > 0) {
			int aa = a.charAt(indexA++) - '0';
			int bb = b.charAt(indexB++) - '0';
			if ((aa & 1) == 1) {
				carry++;
			}
			if ((bb & 1) == 1) {
				carry++;
			}
			sb.insert(0, carry % 2);
			carry = carry / 2;
		}
		while (indexA < a.length()) {
			int aa = a.charAt(indexA++) - '0';
			if ((aa & 1) == 1) {
				carry++;
			}
			sb.insert(0, carry % 2);
			carry = carry / 2;
		}
		while (indexB < b.length()) {
			int bb = b.charAt(indexB++) - '0';
			if ((bb & 1) == 1) {
				carry++;
			}
			sb.insert(0, carry % 2);
			carry = carry / 2;
		}

		if (carry > 0) {
			sb.insert(0, carry);
		}
		return sb.toString();
	}

	public static boolean checkPossibility(int[] nums) {
		boolean flag = true;
		for (int i = 1; i < nums.length && flag; i++) {
			if (nums[i] < nums[i - 1]) {
				if (!flag) {
					return false;
				}
				if (i == 1 || nums[i] >= nums[i - 2]) {
					nums[i - 1] = nums[i];
				} else {
					nums[i] = nums[i - 1];
				}
				flag = false;
			}
		}
		return true;
	}

	private static int quickSelect(int[] nums, int k) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int pivot = partition(nums, start, end);
			if (pivot == k) {
				return nums[k];
			}
			if (k > pivot) {
				start = pivot + 1;
			} else {
				end = pivot - 1;
			}
		}
		return -1;
	}

	private static int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int i = start;
		for (int j = start; j < end; j++) {
			if (nums[j] <= pivot) {
				swap(nums, i++, j);
			}
		}
		swap(nums, i, end);
		return i;
	}

	private static void swap2(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void mainc(String args[]) {
		int gas[] = { 1, 2, 3, 4, 5 };
		int cost[] = { 3, 4, 5, 1, 2 };
		canCompleteCircuit(gas, cost);
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int min = 0;
		int sum = 0;
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			if (sum < min) {
				min = gas[i] - cost[i];
				start = i + 1;
			}
		}
		return sum < 0 ? -1 : start;
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		int count = 0;
		ListNode node = head;
		while (node != null) {
			count++;
			node = node.next;
		}
		count = count - n;
		if (count == 0) {
			return head.next;
		}

		int index = 0;
		ListNode prev = null;
		node = head;
		while (index < count) {
			prev = node;
			node = node.next;
			index++;
		}
		if (prev != null) {
			prev.next = node.next;
		}
		return head;
	}

	public static int numSquares(int n) {
		int gmin = Integer.MAX_VALUE;
		int dp[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
				if (i - j * j >= 0) {
					min = Math.min(min, dp[i - j * j] + 1);
				}
			}
			dp[i] = min;
			gmin = Math.min(dp[i], gmin);
		}
		return gmin;
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> results = new ArrayList<>();
		int i = 0, n = nums.length;
		while (i < n) {
			if (nums[i] == i + 1) {
				i++;
			} else if (nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			} else {
				i++;
			}
		}

		i = 0;
		while (i < n) {
			if (nums[i] != i + 1) {
				results.add(i + 1);
			}
			i++;
		}
		return results;

	}

	private static int common(String str1, String str2) {
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}

	public static int countSegments(String str) {
		if (str.length() == 0) {
			return 0;
		}

		int res = 0;
		int chars = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && i != 0 && i != (str.length() - 1)) {
				res++;
			} else if (str.charAt(i) != ' ') {
				chars++;
			}
		}
		return chars == 0 ? 0 : ++res;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjs = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjs.add(new ArrayList<>());
		}
		for (int[] prerequisite : prerequisites) {
			adjs.get(prerequisite[1]).add(prerequisite[0]);
		}
		boolean visited[] = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, visited, adjs)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int vertex, boolean visited[], List<List<Integer>> adjs) {
		if (visited[vertex]) {
			return false;
		} else {
			visited[vertex] = true;
		}

		for (int vertexB : adjs.get(vertex)) {
			if (!visited[vertexB] && !dfs(vertexB, visited, adjs)) {
				return false;
			}
		}

		visited[vertex] = false;
		return true;
	}
}
