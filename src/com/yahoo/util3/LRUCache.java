package com.yahoo.util3;

import java.util.*;

class LRUCache {
    private Map<Integer, DLinkedList> cache;
    private DLinkedList first, last;
    private int limit;
    
    public static void main(String strs[]){
    	//[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.get(1);
    	cache.put(3, 3);
    	cache.get(2)
    }
    
    public LRUCache(int capacity) {
        this.limit = capacity;
        cache = new HashMap<>();
        first = new DLinkedList();
        last = new DLinkedList();
        first.next = last;
        last.prev = first;
    }
    
    public int get(int key) {
        DLinkedList data = cache.get(key);
        if (data == null) {
            return -1;
        } else {
            moveToHead(data);
        }
        return data.value;
    }
    
    public void put(int key, int value) {
        DLinkedList data = cache.get(key);
        if (data == null) {
            data = new DLinkedList();
            data.key = key;
            data.value = value;
            if (cache.size() + 1 > limit) {
                DLinkedList dNode = popTail();
                deleteNode(dNode);
                cache.remove(key, data);
            }
            cache.put(key, data);
            addNode(data);
        } else {
            data.value = value;
            moveToHead(data);
        }
    }
    private void addNode(DLinkedList dList) {
        DLinkedList next = first.next;
        first.next = dList;
        dList.next = next;
        next.prev = dList;
        dList.prev = first;
    }
    
    private void moveToHead(DLinkedList node) {
        deleteNode(node);
        addNode(node);
    }
    
    private DLinkedList popTail() {
        DLinkedList data = last.prev;
        deleteNode(data);
        return data;
    }
    
    private void deleteNode(DLinkedList node) {
        DLinkedList next = node.next;
        node.prev.next = node.next;
        next.prev = node.prev;
        
    }
}

class DLinkedList {
    int key;
    int value;
    DLinkedList next;
    DLinkedList prev;
}