package com.yahoo.util;

import java.util.*;

public class LogSystem {
    private TreeMap<Long, Integer> cache;
    public LogSystem() {
        cache = new TreeMap<>();
    }
    
    public static void main(String args[]) {
    	LogSystem ls = new LogSystem();
    	//[[],[1,"2017:01:01:23:59:59"],[2,"2017:01:01:22:59:59"],[3,"2016:01:01:00:00:00"],["2016:01:01:01:01:01","2017:01:01:23:00:00","Year"],["2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"]]
    	ls.put(1,"2017:01:01:23:59:59");
    	ls.put(2,"2017:01:01:22:59:59");
    	ls.put(3,"2016:01:01:00:00:00");
    	ls.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
    	
    }
    
    public void put(int id, String timestamp) {
        String splits[] = timestamp.split(":");
        cache.put(convert(splits), id);
    }
    
    private long convert(String splits[]) {
        long result = Integer.parseInt(splits[0]) - 1999 * (12 * 31 * 24 * 60 * 60) +
                                    Integer.parseInt(splits[1]) * (31 * 24 * 60 * 60) +
                                    Integer.parseInt(splits[2]) * (24 * 60 * 60) +
                                    Integer.parseInt(splits[3]) * (60 * 60) +
                                    Integer.parseInt(splits[4]) * (60) +
                                    Integer.parseInt(splits[5]);
        return result;
    }
    
    private long convert2(int splits[]) {
        long result = splits[0] - 1999 * (12 * 31 * 24 * 60 * 60) +
                                    splits[1] * (31 * 24 * 60 * 60) +
                                    splits[2] * (24 * 60 * 60) +
                                    splits[3] * (60 * 60) +
                                    splits[4] * (60) +
                                    splits[5];
        return result;
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Year", 0);
        map.put("Month", 1);
        map.put("Day", 2);
        map.put("Hour", 3);
        map.put("Minute", 4);
        map.put("Second", 5);
        String res[] = {"1999", "00", "00", "00", "00", "00"};
        String ssplits [] = s.split(":");
        for (int i = 0; i <= map.get(gra); i++) {
            res[i] = ssplits[i];
        }
        int rr [] = new int [6];
        for (int i = 0; i < rr.length; i++) {
            rr[i] = Integer.parseInt(res[i]);
        }
        long start = convert(ssplits);
        List<Integer> results = new ArrayList<>();
        rr[map.get(gra)]++;
        long end = convert2(rr);
        for ( long entry : cache.tailMap(start).keySet()) {
            if (entry > start && entry < end  ) {
                results.add(cache.get(entry));
            }
        }
        return results;
    }
}