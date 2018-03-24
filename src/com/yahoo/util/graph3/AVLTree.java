package com.yahoo.util.graph3;

class AVLTree {

	private Node leftRotate(Node root){
		Node newRoot = root.right;
		newRoot.left = root;
		root.right = root.right.left;
		newRoot.height = setHeight(newRoot);
		newRoot.size = setSize(newRoot);
		root.height = setHeight(root);
		root.size = setSize(root);
		return newRoot;
	}
	
	private Node rightRotate(Node root){
		Node newRoot = root.left;
		newRoot.right = root;
		root.left = root.left.right;
		newRoot.height = setHeight(newRoot);
		newRoot.size = setSize(newRoot);
		root.height = setHeight(root);
		root.size = setSize(root);
		return newRoot;
	}
	public Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else if (data >= root.val) {
			root.right = insert(root.right, data);
		} else {
			root.left = insert(root.left, data);
		}
		int height = balance(root.left, root.right);
		if (height > 1) {
			if (height(root.left.left) >= height(root.left.right)) {
				rightRotate(root);
			} else {
				root.left = leftRotate(root.left);
				rightRotate(root);
			}
		} else if (height < -1) {
			if (height(root.right.right) >= height(root.right.left)) {
				leftRotate(root);
			} else {
				root.right = rightRotate(root.right);
				leftRotate(root);
			}
		} else {
			root.height = setHeight(root);
			root.size = setSize(root);
		}
		return root;
	}

	private int setHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(root.left != null ? 0 : root.left.height, root.right != null ? 0 : root.right.height);
	}

	private int setSize(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max((root.left != null ? root.left.size : 0), (root.right != null ? root.right.size : 0));
	}

	private int balance(Node left, Node right) {
		return left.height - right.height;
	}
	
	private int height(Node root){
        if(root == null){
            return 0;
        }else {
            return root.height;
        }
    }
}

class Node {
	int val;
	int height;
	int size;

	Node right = null, left = null;

	public Node(int data) {
		this.val = data;
	}
}