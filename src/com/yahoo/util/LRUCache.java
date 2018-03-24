package com.yahoo.util;

import java.util.*;

public class LRUCache {
    private int capacity;
    private TreeMap<String, Integer> lru = new TreeMap<>();
    private TreeMap<Integer, String> rlru = new TreeMap<>();
    private Map<Integer, Integer> cache = new HashMap<>();
    private volatile int counter = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // if key exists, update Lru time
        Integer k = new Integer(key);
        if (cache.containsKey(k)) {
        	String time = rlru.get(k);
            lru.remove(time);
            rlru.remove(k);
            
            String ntime = "K" + counter++;
            rlru.put(key, ntime);
            lru.put(ntime, key);
            System.out.println("get lru " + lru);
            System.out.println("get rlru " + rlru);
            return cache.get(k);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Integer k = new Integer(key);
        if ((cache.size() + 1) > capacity) {
            // remove the element
            Map.Entry<String, Integer> entry = lru.firstEntry();
            cache.remove(entry.getValue());
            lru.remove(entry.getKey());
            rlru.remove(entry.getValue());
        }
        cache.put(k, value);
        String time = "K" + counter++;
        lru.put(time, k);
        rlru.put(k, time);
        System.out.println("put lru " + lru);
        System.out.println("put rlru " + rlru);
    }
    
    public static void main(String args[]) {
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.get(1);       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	cache.get(2);       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	cache.get(1);       // returns -1 (not found)
    	cache.get(3);       // returns 3
    	cache.get(4);       // returns 4
    }
}
