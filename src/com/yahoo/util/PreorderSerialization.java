package com.yahoo.util;

import java.util.*;

public class PreorderSerialization {

	public static void main(String args[]) {
		String str = "9,#,92,#,#";
		System.out.println(isValidSerialization(str));
	}
	
	public static boolean isValidSerialization(String preorder) {
		if (preorder == null) {
			return false;
		}

		if (preorder.length() == 1 && preorder.charAt(0) == '#') {
			return true;
		} else if (preorder.length() > 1 && preorder.charAt(0) == '#') {
			return false;
		}

		String splits[] = preorder.split(",");
		Stack<Integer> stack = new Stack<Integer>();
		int index = 1;
		stack.add(index);
		int max = index;
		while (!stack.empty()) {
			int currentIndex = stack.pop();
			int left = currentIndex * 2;
			int right = currentIndex * 2 + 1;
			max = right;

			// check if it's valid
			if (!isValid(currentIndex, splits, splits.length)) {
				return false;
			}

			// if (splits[currentIndex -1].equals("#")) {
			// ret;
			// }

			// add right and left if it's not #
			if (!splits[right - 1].equals("#")) {
				stack.push(right);
			}

			if (!splits[left - 1].equals("#")) {
				stack.push(left);
			}
		}

		if (max < splits.length) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Check if given current Index as left and right
	 **/
	public static boolean isValid(int currentIndex, String splits[], int cSplitLength) {
		int left = currentIndex * 2;
		int right = currentIndex * 2 + 1;

		if (splits[currentIndex - 1].equals("#") || (left <= cSplitLength && right <= cSplitLength)) {
			return true;
		} else {
			return false;
		}
	}
}
