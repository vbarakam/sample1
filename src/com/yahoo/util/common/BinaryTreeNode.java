package com.yahoo.util.common;

public class BinaryTreeNode<T extends Comparable<T>> {

  protected BinaryTreeNode<T> parent;
  protected BinaryTreeNode<T> right;
  protected BinaryTreeNode<T> left;
  protected T value;

  public BinaryTreeNode(T value) {
    this.value = value;
  }
  
  public BinaryTreeNode<T> getParent() {
    return parent;
  }

  public void setParent(BinaryTreeNode<T> parent) {
    this.parent = parent;
  }

  public BinaryTreeNode<T> getRight() {
    return right;
  }

  public void setRight(BinaryTreeNode<T> right) {
    this.right = right;
  }

  public BinaryTreeNode<T> getLeft() {
    return left;
  }

  public void setLeft(BinaryTreeNode<T> left) {
    this.left = left;
  }  

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
