package com.yahoo.util;

import java.util.Random;
import java.util.*;

public class Test {
	private TreeNode prev = null;

	public static void main(String args[]) {
		// 3.5
		int nums[] = { 3, 4, 2, 3 };
		//checkPossibility(nums);
		String str2 = "1011";
		String str = "Hello, my name is John";
		countSegments(str);
	}

	public static int countSegments(String s) {
		int count = 0;
		int index = 0;

		while (index < s.length()) {
			while (index < s.length() && s.charAt(index) == ' ') {
				index++;
			}
				;
			int cnt = 0;
			System.out.println( " xx " + s.charAt(index) );
			while (index < s.length() && s.charAt(index) != ' ') {
				cnt++;
				index++;
			}
			if (cnt > 0) {
				count++;
			}
			while (index < s.length() && s.charAt(index) == ' ') {
				index++;
			}
		}
		return count;
	}

	public static boolean checkPossibility(int[] nums) {
		int count = 0;
		for (int i = 1; i < nums.length && count < 2; i++) {
			if (nums[i] < nums[i - 1]) {
				count++;
				nums[i - 1] = nums[i];
			}
		}
		return count > 1 ? false : true;
	}

	public static String addBinary(String a, String b) {
		Stack<Integer> stack1 = new Stack<>();
		int i = a.length() - 1;
		while (i >= 0) {
			stack1.push(a.charAt(i--) - '0');
		}
		Stack<Integer> stack2 = new Stack<>();
		i = b.length() - 1;
		while (i >= 0) {
			stack2.push(b.charAt(i--) - '0');
		}
		LinkedList<Integer> result = new LinkedList<>();
		int carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int num1 = stack1.isEmpty() ? 0 : stack1.pop();
			int num2 = stack2.isEmpty() ? 0 : stack2.pop();
			carry = carry + num1 + num2;
			result.addFirst(carry % 2);
			carry = carry / 2;
		}
		if (carry != 0) {
			result.addFirst(carry);
		}
		StringBuilder sb = new StringBuilder();
		for (int num : result) {
			sb.append(num);
		}
		return sb.toString();
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		int index = 0;
		// 1->2->3->4->5
		// prev1=1, next1= 2
		// prev2=3, next2= 4
		// 1->2<-3<-4->5
		// 1->4->3->2->5
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, prev1 = null, next1 = null, prev2 = null, next2 = null, next3 = null;
		ListNode node = head;
		while (node != null) {
			index++;
			if (index == m) {
				prev1 = prev;
				next1 = node;
			} else if (index == n) {
				prev2 = prev;
				next2 = node;
				next3 = node.next;
			}
			ListNode temp = node.next;
			if (index > m && index <= n) {
				node.next = prev;
			}
			prev = node;
			node = temp;
		}

		prev1.next = next2;
		next1.next = next3;
		return dummy.next;
	}

	private static void aa(int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j >= 0; j--) {

			}
		}
	}

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> results = new ArrayList<>();
		factors(n, results, new ArrayList<Integer>());
		return results;
	}

	private static void factors(int n, List<List<Integer>> results, List<Integer> result) {
		System.out.println(n);
		if (n == 1) {
			results.add(new ArrayList<Integer>(result));
			return;
		}

		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				result.add(i);
				factors(n / i, results, result);
				result.remove(result.size() - 1);
			}
		}
	}

	private static void status(int nums[], int start, List<Integer> current) {
		System.out.println(" :: " + current);

		if (current.size() == nums.length) {
			return;
		}

		for (int i = start; i < nums.length; i++) {
			current.add(nums[i]);
			status(nums, i + 1, current);
			current.remove(current.size() - 1);
		}
	}

	public static void main22(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		Test test = new Test();
		test.flatten(root);
	}

	private void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.left);
		flatten(root.right);
		root.right = prev;
		root.left = null;
		prev = root;

	}

	public static void main6(String args[]) {
		Random rand = new Random(2);
		for (int num = 1; num < 25; num++) {
			System.out.println(" " + rand.nextInt(num));
		}
	}

	public static void main33(String args[]) {
		String str = "/path1/path2";
		String str2 = "/path1";
		String splits[] = str.split("\\/");
		System.out.println(splits.length);
		System.out.println(str2.substring(0, str2.lastIndexOf("/")));

	}

	public static void subset(String soFar, String rest) {
		if (rest.isEmpty()) {
			System.out.println(" sub set : " + soFar);
			return;
		}

		subset(soFar + rest.charAt(0), rest.substring(1));
		subset(soFar, rest.substring(1));

	}

	public static void permute(String soFar, String rest) {
		if (rest.isEmpty()) {
			System.out.println(" soFar " + soFar);
		} else {
			for (int i = 0; i < rest.length(); i++) {
				String remaining = rest.substring(0, i) + rest.substring(i + 1);
				permute(soFar + rest.charAt(i), remaining);
			}
		}
	}

	public static String addStrings(String num1, String num2) {
		int max = (num1.length() > num2.length() ? num1.length() : num2.length()) - 1;
		int min = (num1.length() < num2.length() ? num1.length() : num2.length()) - 1;

		String maxString = num1.length() > num2.length() ? num1 : num2;
		String minString = (maxString.equals(num1)) ? num2 : num1;

		StringBuilder sb = new StringBuilder();
		int carryover = 0;
		for (int index = max; index >= 0; index--) {
			int first = toInt(maxString.charAt(index));

			int second = 0;
			if (min >= 0) {
				second = toInt(minString.charAt(min));
				min = min - 1;
			}

			int sum = first + second + carryover;
			if (sum > 9) {
				carryover = 1;
				sb.append(sum - 10);
			} else {
				carryover = 0;
				sb.append(sum);
			}
		}

		// add last carry over
		if (carryover > 0) {
			sb.append(carryover);
		}

		return sb.reverse().toString();
	}

	public static int toInt(char num) {
		return (num - '0');
	}

	public static long toInt(String num1) {
		long sum = 0;
		for (int index = 0; index < num1.length(); index++) {
			System.out.println((num1.charAt(index) - '0'));
			sum = sum * 10 + (num1.charAt(index) - '0');
		}
		return sum;
	}

	public static boolean isPalindrome(String s) {
		// empty and single char string is valid palindrome
		if (s.trim().length() == 0 || s.trim().length() == 1) {
			return true;
		}

		char[] chars = s.toCharArray();
		int start = 0;
		int end = chars.length - 1;
		while (start < end) {
			if (!((chars[start] >= 'a' && chars[start] <= 'z') || (chars[start] >= 'A' && chars[start] <= 'Z')
					|| (chars[start] >= '0' && chars[start] <= '9'))) {
				start += 1;
				continue;
			}

			if (!((chars[end] >= 'a' && chars[end] <= 'z') || (chars[end] >= 'A' && chars[end] <= 'Z')
					|| (chars[end] >= '0' && chars[end] <= '9'))) {
				end -= 1;
				continue;
			}

			if (chars[start] != chars[end]) {
				return false;
			}
		}
		return true;
	}

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		boolean match = false;
		int j = 0;
		int startIndex = -1;
		char[] hays = haystack.toCharArray();
		char[] nees = needle.toCharArray();
		for (int i = 0; i < hays.length; i++) {
			if (j < nees.length) {
				if (hays[i] == nees[j]) {
					if (!match) {
						startIndex = i;
					}
					match = true;
					j += 1;
				} else {
					if (match) {
						i = startIndex;
					}
					match = false;
					j = 0;
				}
			} else {
				break;
			}
		}
		System.out.println(" match " + match);
		System.out.println(" j " + j);
		System.out.println(" startIndex " + startIndex);
		return match ? (j < nees.length ? -1 : startIndex) : -1;
	}

	public static String longestCommonPrefix(String[] strs) {
		// if strs is null or length is zero size
		if (strs == null || strs.length == 0) {
			return "";
		}

		// if the array contains only one string
		if (strs.length == 1) {
			return strs[0];
		}

		// consider first str as base
		String previous = "";
		for (int index = 1; index <= strs[0].length(); index++) {
			String subString = strs[0].substring(0, index);
			boolean good = true;
			for (int aindex = 1; aindex < strs.length; aindex++) {
				if (!strs[aindex].startsWith(subString)) {
					good = false;
					break;
				}
			}
			if (good) {
				previous = subString;
			} else {
				break;
			}
		}

		// return the prefix
		return previous;
	}
}
