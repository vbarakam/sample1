package com.yahoo.util3;

import java.util.*;

public class SerializeandDeserializeBinaryTree {
	public static void main(String args[]) {
		Codec codec = new Codec();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		System.out.println(codec.serialize(root));
		System.out.println(codec.serialize(codec.serialize(root)));
	}
}
 class Codec {
	private static final String NULL = "NA";
	private static final String DELIM = ",";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize2(root, sb);
		return sb.toString();
	}

	private void serialize2(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(NULL).append(DELIM);
			return;
		}

		sb.append(root.val).append(DELIM);
		serialize2(root.left, sb);
		serialize2(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}
		String splits[] = data.split(DELIM);
		if (splits.length == 0) {
			return null;
		}

		Queue<String> queue = new LinkedList<String>(Arrays.asList(splits));
		return deserialize2(queue);
	}

	private TreeNode deserialize2(Queue<String> queue) {
		if (queue.isEmpty() || queue.peek() == null || queue.peek().equals(NULL)) {
			return null;
		}
		String str = queue.poll();
		TreeNode root = new TreeNode(new Integer(str));
		root.left = deserialize2(queue);
		root.right = deserialize2(queue);
		return root;
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