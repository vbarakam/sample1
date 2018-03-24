package com.yahoo.mediam;

public class ValidateBinarySearchTree {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		//root.right = new TreeNode(3);
		System.out.println(check(root));
	}

	private static boolean check(TreeNode root) {
		if (root == null) {
			return true;
		}

		if ((root.left == null || root.left.val < root.val) && (root.right == null || root.right.val > root.val)) {
			return check(root.left) && check(root.right);
		} else {
			return false;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
