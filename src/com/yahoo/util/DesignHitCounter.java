package com.yahoo.util;

import java.util.*;

public class DesignHitCounter {
	public static void main(String args[]) {
		HitCounter counter = new HitCounter();

		// hit at timestamp 1.
		counter.hit(1);

		// hit at timestamp 2.
		counter.hit(2);

		// hit at timestamp 3.
		counter.hit(3);

		// get hits at timestamp 4, should return 3.
		counter.getHits(4);

		// hit at timestamp 300.
		counter.hit(300);

		// get hits at timestamp 300, should return 4.
		counter.getHits(300);

		// get hits at timestamp 301, should return 3.
		counter.getHits(301); 
	}
}

class HitCounter {
    private Map<Integer, Integer> cache;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        cache = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int bucket = (timestamp -1) / 300;
        cache.put(bucket, cache.getOrDefault(bucket,0)+1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }
}
