package com.yahoo.util.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
  private BinaryTreeNode<T> root;

  public BinaryTreeNode<T> getRoot() {
    return root;
  }

  public void setRoot(BinaryTreeNode<T> root) {
    this.root = root;
  }

  public BinaryTreeNode<T> isearch(BinaryTreeNode<T> root, T key) {
    if (root == null) {
      return null;
    }
    BinaryTreeNode<T> temp = root;

    while (temp != null) {
      if (key.compareTo(temp.getValue()) == 0) {
        return temp;
      }

      if (key.compareTo(temp.getValue()) < 0) {
        temp = temp.left;
      } else {
        temp = temp.right;
      }
    }
    return null;
  }

  public BinaryTreeNode<T> min(BinaryTreeNode<T> node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
  
  public BinaryTreeNode<T> max(BinaryTreeNode<T> node) {
    while (node != null && node.right != null) {
      node = node.right;
    }
    return node;
  }
  
  public BinaryTreeNode<T> search(BinaryTreeNode<T> node, T key) {
    if (node == null) {
      return null;
    }
    if (node != null && key.compareTo(node.getValue()) == 0) {
      return node;
    }

    if (key.compareTo(node.getValue()) < 0) {
      return search(node.left, key);
    } else {
      return search(node.right, key);
    }
  }

  public void insert(BinaryTreeNode<T> node) {
    // check if root is null
    if (this.root == null) {
      this.root = node;
      return;
    }

    // iterate through the tree until you find right position in
    // the tree for the node
    BinaryTreeNode<T> x = this.root;
    BinaryTreeNode<T> y = x;
    while (x != null) {
      y = x;
      if (node.getValue().compareTo(x.getValue()) < 0) {
        x = x.getLeft();
      } else {
        x = x.getRight();
      }
    }

    // add the node to the tree
    if (node.getValue().compareTo(y.getValue()) < 0) {
      y.setLeft(node);
    } else {
      y.setRight(node);
    }

  }

  public void delete(BinaryTreeNode<T> node) {

    if (node.left == null) {
      transplant(node, node.right);
    } else if (node.right == null) {
      transplant(node, node.left);
    } else {

    }

  }

  private void transplant(BinaryTreeNode<T> node, BinaryTreeNode<T> replacementSubtrees) {
    // check if it's a root node
    if (node.parent == null) {
      this.root = replacementSubtrees;
      return;
    }

    // update replacement subtree parent
    replacementSubtrees.parent = node.parent;

    // update delete node parent left/right pointer with new subtree
    if (node.parent.left == node) {
      node.parent.left = replacementSubtrees;
    } else {
      node.parent.right = replacementSubtrees;
    }
  }

  public void printNode(BinaryTreeNode<T> root) {
    int maxLevel = maxLevel(root);

    printNodeInternal(Collections.singletonList(root), 1, maxLevel);
  }

  private void printNodeInternal(List<BinaryTreeNode<T>> nodes, int level, int maxLevel) {
    if (nodes.isEmpty() || BinaryTree.isAllElementsNull(nodes))
      return;

    int floor = maxLevel - level;
    int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
    int firstSpaces = (int) Math.pow(2, (floor)) - 1;
    int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

    BinaryTree.printWhitespaces(firstSpaces);

    List<BinaryTreeNode<T>> newNodes = new ArrayList<BinaryTreeNode<T>>();
    for (BinaryTreeNode<T> node : nodes) {
      if (node != null) {
        System.out.print(node.getValue());
        newNodes.add(node.left);
        newNodes.add(node.right);
      } else {
        newNodes.add(null);
        newNodes.add(null);
        System.out.print(" ");
      }

      BinaryTree.printWhitespaces(betweenSpaces);
    }
    System.out.println("");

    for (int i = 1; i <= endgeLines; i++) {
      for (int j = 0; j < nodes.size(); j++) {
        BinaryTree.printWhitespaces(firstSpaces - i);
        if (nodes.get(j) == null) {
          BinaryTree.printWhitespaces(endgeLines + endgeLines + i + 1);
          continue;
        }

        if (nodes.get(j).left != null)
          System.out.print("/");
        else
          BinaryTree.printWhitespaces(1);

        BinaryTree.printWhitespaces(i + i - 1);

        if (nodes.get(j).right != null)
          System.out.print("\\");
        else
          BinaryTree.printWhitespaces(1);

        BinaryTree.printWhitespaces(endgeLines + endgeLines - i);
      }

      System.out.println("");
    }

    printNodeInternal(newNodes, level + 1, maxLevel);
  }

  private static void printWhitespaces(int count) {
    for (int i = 0; i < count; i++)
      System.out.print(" ");
  }

  private int maxLevel(BinaryTreeNode<T> node) {
    if (node == null)
      return 0;

    return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
  }

  private static <T> boolean isAllElementsNull(List<T> list) {
    for (Object object : list) {
      if (object != null)
        return false;
    }

    return true;
  }

  public void printPreOrder(BinaryTreeNode<Integer> node) {
    if (node == null) {
      return;
    }
    System.out.print(" " + node.getValue());
    printPreOrder(node.left);
    printPreOrder(node.right);
  }

  public void printInOrder(BinaryTreeNode<Integer> node) {
    if (node == null) {
      return;
    }
    printInOrder(node.left);
    System.out.print(" " + node.getValue());
    printInOrder(node.right);
  }

  public void printPostOrder(BinaryTreeNode<Integer> node) {
    if (node == null) {
      return;
    }
    printPostOrder(node.left);
    printPostOrder(node.right);
    System.out.print(" " + node.getValue());

  }

  public static void main(String args[]) {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(15);
    BinaryTreeNode<Integer> n11 = new BinaryTreeNode<Integer>(6);
    BinaryTreeNode<Integer> n12 = new BinaryTreeNode<Integer>(18);
    BinaryTreeNode<Integer> n21 = new BinaryTreeNode<Integer>(3);
    BinaryTreeNode<Integer> n22 = new BinaryTreeNode<Integer>(7);
    BinaryTreeNode<Integer> n23 = new BinaryTreeNode<Integer>(17);
    BinaryTreeNode<Integer> n24 = new BinaryTreeNode<Integer>(20);
    BinaryTreeNode<Integer> n31 = new BinaryTreeNode<Integer>(2);
    BinaryTreeNode<Integer> n32 = new BinaryTreeNode<Integer>(4);
    BinaryTreeNode<Integer> n33 = new BinaryTreeNode<Integer>(13);
    BinaryTreeNode<Integer> n41 = new BinaryTreeNode<Integer>(9);



    root.left = n11;
    root.right = n12;

    n11.left = n21;
    n11.right = n22;

    n22.right = n33;

    n33.left = n41;

    n12.left = n23;
    n12.right = n24;

    n21.left = n31;
    n21.right = n32;


    BinaryTree<Integer> tree = new BinaryTree<Integer>();
    tree.setRoot(root);

    tree.printNode(root);

    System.out.println(tree.isearch(tree.root, 15).getValue());
    System.out.println(tree.isearch(tree.root, 17).getValue());
    System.out.println(tree.isearch(tree.root, 20).getValue());
    System.out.println(tree.isearch(tree.root, 9).getValue());
    System.out.println(tree.isearch(tree.root, 2).getValue());
    System.out.println(tree.isearch(tree.root, 7).getValue());
    System.out.println(tree.isearch(tree.root, 200));
    
    System.out.println("min :: " + tree.min(tree.root).getValue());
    System.out.println("max :: " + tree.max(tree.root).getValue());

  }
}
