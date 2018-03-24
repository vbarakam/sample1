package com.yahoo.util;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(zigzagLevelOrder(root));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, result, 0);
        return result;
    }
    
    private static void backtrack(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        
        if (level <= result.size()) {
            result.add(new ArrayList<>());
        }
        
        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).add(0, root.val);
        }
        
        backtrack(root.left, result, level+1);
        backtrack(root.right, result, level+1);
    }
}

class TreeNodeWrapper {
	TreeNode node;
	int level;

	public TreeNodeWrapper(TreeNode root, int level) {
		this.node = root;
		this.level = level;
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
