package com.yahoo.util.trees;

public class Node<T extends Comparable<T>> {
  Node left;
  Node right;
  Node parent;
  T key;
}
