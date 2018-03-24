package com.yahoo.util;

import java.util.*;

public class LFUCache {
    private Node head;
    private Map<Integer, Integer> valueSet;
    private Map<Integer, Node> nodeSet;
    private int cap;

    public LFUCache(int capacity) {
        valueSet = new HashMap<>();
        nodeSet = new HashMap<>();
        head = null;
        cap = capacity;
        
    }
    
    public static void main(String args[]) {
    	LFUCache obj = new LFUCache(1);
    	//[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
    	//["LFUCache","put","get","put","get","get"]
    	//[[1],[2,1],[2],[3,2],[2],[3]]
    	obj.put(2, 1);
    	//obj.put(2, 2);
    	System.out.println(obj.get(2));
    	obj.put(3, 2);
    	System.out.println(obj.get(2));
    	System.out.println(obj.get(3));
    }
    
    public int get(int key) {
        if (valueSet.containsKey(key)) {
            int temp = valueSet.get(key);
            incrementOne(key);
            return temp;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if (valueSet.containsKey(key)) {
            valueSet.put(key, value);
        } else {
            if (valueSet.size() + 1 > cap) {
                removeOld();
                valueSet.put(key, value);
            } else {
                valueSet.put(key, value);
            }
            addToHead(key);
        }
        incrementOne(key);
    }
    
    private void removeOld() {
        if (head == null) {
            return;
        }
        int old = 0;
        for (int n : head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) {
            remove(head);
        }
        valueSet.remove(old);
        nodeSet.remove(old);
    }
    
    private void remove(Node node) {
        if (node == null) {
            return;
        }
        // first node
        if (node.prev == null) {
        	head = node.next;
            head.prev = null;
            return;
        }
        // last node
        if (node.next ==  null) {
            node.prev.next = null;
        }
        
        // middle node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void incrementOne(int key) {
        Node node = nodeSet.get(key);
        node.keys.remove(key);
        
        if (node.next == null) {
            Node temp = new Node(node.count + 1);
            temp.keys.add(key);
            node.next = temp;
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            Node temp = new Node(node.count + 1);
            temp.keys.add(key);
            temp.next = node.next;
            temp.prev = node;
            node.next = temp;
            temp.next.prev = temp;
            
        }
        nodeSet.put(key, node.next);
        if (node.keys.size() == 0) {
            remove(node);
        }
    }
    
    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            Node node = new Node(0);
            head.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        nodeSet.put(key, head);
    }
}

class Node {
    int count;
    Node prev = null, next = null;
    LinkedHashSet<Integer> keys = null;
    
    public Node(int n) {
        count = n;
        keys = new LinkedHashSet<>();
    }
}