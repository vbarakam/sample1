package com.yahoo.util;

import com.yahoo.util.trees.TreeNode;

public class LinkedList1 {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);
		root.left.left.left.left.left = new TreeNode(6);
		root.left.left.left.left.left.left = new TreeNode(7);
		
		TreeNode fast = root, slow = root;
		while (fast != null && fast.left != null) {
			slow = slow.left;
			fast = fast.left.left;

			System.out.println(" Slow ->>>> " + (slow != null ? slow.val : ""));
			System.out.println(" Fast ->>>> " + (fast != null ? fast.val : ""));
		}
		
		if (fast != null) {
			slow = slow.left;
		}
		
		TreeNode node = reverse(slow);
		fast = node;
		while (node != null) {
			if (node.val != fast.val) {
				System.out.println("Not Palin");
			}
			fast = fast.left;
			node = node.left;
			
		}
		
	}
	
	private static TreeNode reverse(TreeNode node) {
		TreeNode previous = null;
		while (node != null) {
			TreeNode next = node.left;
			node.left = previous;
			previous = node;
			node = next;
		}
		return previous;
	}
	
}
