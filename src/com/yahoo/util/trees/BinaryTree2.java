package com.yahoo.util.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree2<T extends Comparable<T>> {
  Node root;
  
  public Node<T> getRoot() {
    return this.root;
  }
  
  public static Node min(Node node) {
    Node min = node;
    while (min.left != null) {
    	min = min.left;
    }
    return min;
  }
  
  public static Node max(Node node) {
	  Node max = node;
	  while (max.right != null) {
		  max = max.right;
	  }
	  return max;
  }
  
  public static Node predecessor(Node  node) {
    // if right node is available return max of right subtree
    if (node.left != null) {
      max(node.left);
    }
    
    // ancestor of 
    Node current = node;
    Node parent = node.parent;
    while (parent != null && current == parent.left) {
      current = parent;
      parent = parent.parent;
    }
    
    return parent;
  }
  
  public static Node successor(Node node) {
	  // node has right node, return min of right node
	  if (node.right != null) {
		  return min(node.right);
	  }
	  // find the minimum ancestor which left child is also
	  // an ancestor of node
	  Node parent = node.parent;
	  Node current = node;
	  while (parent != null && current == parent.right) {
		  current = parent;
		  parent = parent.parent;
		  
	  }
	  return parent;
  }
  
  @SuppressWarnings("static-access")
public static void main(String args[]) {
    BinaryTree2<Integer> tree = new BinaryTree2<Integer>();
    
    // add root 
    Node<Integer> root = new Node<Integer>();
    root.key = 7;
    tree.insert(root);
    
    tree.print();
    Node<Integer> node1 = new Node<Integer>();
    node1.key = 4;
    tree.insert(node1);
    
    Node<Integer> node2 = new Node<Integer>();
    node2.key = 13;
    tree.insert(node2);
    
    //
    Node node5 = new Node<Integer>();
    node5.key = 1;
    tree.insert(node5);
    
    //
    Node node4 = new Node<Integer>();
    node4.key = 6;
    tree.insert(node4);
    
    node2 = new Node<Integer>();
    node2.key = 10;
    tree.insert(node2);
    
    Node node3 = new Node<Integer>();
    node3.key = 15;
    tree.insert(node3);
    printbreath(tree.root);
    System.out.println(" finding 15 : " +  tree.find(root, 15).key);
    System.out.println(" finding 10 : " +  tree.find(root, 10).key);
    System.out.println(" finding 6 : " +  tree.find(root, 6).key);
    System.out.println(" finding 1 : " +  tree.find(root, 1).key);
    
    System.out.println(" Min : " +  tree.min(root).key);
    System.out.println(" Max : " +  tree.max(root).key);
    
    System.out.println(" Successor of " + node3.key + " is " +  tree.successor(node3));
    
    System.out.println(" Predecessor of " + node3.key + " is " +  tree.predecessor(node3).key);

    
    System.out.println(" Successor of " + node4.key + " is " +  tree.successor(node4).key);
    
    System.out.println(" Predecessor of " + node4.key + " is " +  tree.predecessor(node4).key);

    
    System.out.println(" Successor of " + node2.key + " is " +  tree.successor(node2).key);
    
    System.out.println(" Predecessor of " + node2.key + " is " +  tree.predecessor(node2).key);


    System.out.println(" Successor of " + node5.key + " is " +  tree.successor(node5).key);
    
    System.out.println(" Predecessor of " + node5.key + " is " +  tree.predecessor(node5));




    
  }
  
  protected void insert(Node node) {
    if (root == null) {
      root = node;
      return;
    }
    
    Node parent = null;
    Node current = root;
    while (current != null) {
      parent = current;
      if (node.key.compareTo(current.key) > 0) {
        current = current.right;
      } else {
        current = current.left;
      }
    }
    
    if (node.key.compareTo(parent.key) > 0) {
      parent.right = node;
    } else {
      parent.left = node;
    }
    node.parent = parent;
  }
  
  protected void delete(Node node) {
    
  }
  
  protected void nextElement(Node node) {
    
  }
  
  protected Node<T> find(Node node, T key) {
    if (node == null || node.key.compareTo(key) == 0) {
      return node;
    }
    
    if (node.key.compareTo(key) > 0) {
      return find(node.left, key);
    } else {
      return find(node.right, key);
    }
  }
  
  protected void print() {
    System.out.println(this.getRoot().key);
    System.out.println(this.getRoot().right);
    System.out.println(this.getRoot().left);

  }
  public static void printbreath(Node node) {
    if (node == null) {
      return;
    }
    
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Node n = queue.remove();
      System.out.println(" Node Value : " + n.key);
      if (n.left != null) {
        queue.add(n.left);
      }
      if (n.right != null) {
        queue.add(n.right);
      }
    }
  }
}
