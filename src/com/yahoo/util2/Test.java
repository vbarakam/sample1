package com.yahoo.util2;

import java.util.Arrays;

public class Test {
	public static void main2(String args[]) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(2);
		insert(root, 20);
		insert(root, 1);
		insert(root, 3);
		System.out.println(root.right.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.left.left.val);
		System.out.println(root.left.left.right.val);
	}
	
	public static void main(String args[]) {
		String str = "aab";
		backTrack(str, 0);
	}
	
	public static void backTrack(String s, int l){
		if (l == s.length()) {
			return;
		}
		for (int i = l; i < s.length(); i++) {
			//System.out.println( );
			System.out.println( "0 :: " + i + " " + s.substring(0, i));
		}
	}
	
	private static void insert(TreeNode node, int val) {
		if (node == null) {
			return;
		}
		
		TreeNode previous = null;
		while (node != null) {
			previous = node;
			if (val >= node.val) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		System.out.println(previous);
		if (val >= previous.val) {
			previous.right = new TreeNode(val);
		} else {
			previous.left = new TreeNode(val);
		}
	}
	
	
}
