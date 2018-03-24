package com.yahoo.util;

import java.util.*;

import com.yahoo.util.trees.TreeNode;

public class Codec {
	private static final String spliter = ",";
    private static final String NN = "X";
    
	public static void main(String args[]) {
		//[5,2,3,null,null,2,4,3,1]
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(1);
		String output = serialize(root);
		System.out.println(deserialize2(output));
		System.out.println(output);
	}
	
	
	public static int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
    public static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        buildString(builder, root);
        return builder.toString();
    }
    
    public static void buildString(StringBuilder builder, TreeNode root) {
        if (root == null) {
            builder.append(NN).append(spliter);
        } else {
            builder.append(root.val).append(spliter);
            buildString(builder, root.left);
            buildString(builder, root.right);
        }
    }
    
    public  static TreeNode deserialize2(String data) {
        if (data.trim().length() == 0) {
            return null;
        }
        
        String splits[] = data.split("\\,");
        Deque<String> queue = new LinkedList1<String>();
        queue.addAll(Arrays.asList(splits));
        return buildTree(queue);
    }
        
        
    public static TreeNode buildTree(Deque<String> queue) {
    	String data = queue.remove();
 
        if (data.equals(NN)) {
        	return null;
        } else {
        	TreeNode node = new TreeNode(Integer.parseInt(data));
        	node.left = buildTree(queue);
        	node.right = buildTree(queue);
        	
        	return node;
        }
    }
    
    // Encodes a tree to a single string.
	public static String serialize2(TreeNode root) {
		List<Integer> elements = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList1<>();

		if (root != null) {
			queue.add(root);
			elements.add(root.val);
			while (!queue.isEmpty()) {
				TreeNode node = queue.remove();
				elements.add(node.left == null ? null : node.left.val);
				elements.add(node.right == null ? null : node.right.val);

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		String data = elements.toString();
		return data.substring(1, data.length() - 1);
	}

	// Decodes your encoded data to tree.
	public static TreeNode  deserialize(String data) {
        if (data.trim().length() == 0) {
            return null;
        }
        
        //
        String splits[] = data.split("\\,");
        
        Integer index  = 0;
        Map<Integer, TreeNode> treeMap = new HashMap<>();
        while (index < splits.length) {
            // create node
            TreeNode node = treeMap.get(index);
            if (node == null && !splits[index].trim().equals("null")) {
                node = new TreeNode(new Integer(splits[index].trim()));
            }
            treeMap.put(index, node);
            
            // create left node 2x+1
            int leftIndex = 2*index+1;
            TreeNode left = treeMap.get(leftIndex);
            if (left == null && leftIndex < splits.length && !splits[2*index+1].trim().equals("null")) {
                left = new TreeNode(new Integer(splits[2*index+1].trim()));
            }
            treeMap.put(2*index+1, left);
            
            
            // create right node 2x+2
            TreeNode right = treeMap.get(2*index+2);
            int rightIndex = 2*index+2;
            if (right == null && rightIndex < splits.length && !splits[2*index+2].trim().equals("null")) {
                right = new TreeNode(new Integer(splits[2*index+2].trim()));
            }
            treeMap.put(2*index+2, right);
            
            if (node != null) {
                node.right = right;
                node.left = left;
            }
            
            index++;
        }
        
        return treeMap.get(0);
    }
}
