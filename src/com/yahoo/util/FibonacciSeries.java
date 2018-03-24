package com.yahoo.util;

import java.util.Map;
import java.util.HashMap;

public class FibonacciSeries {
  public static void main(String args[]) {
    Map<Integer,Integer> cache = new HashMap<>();
    System.out.println(fs(10, cache));
  }
  
  public static int fs(int n, Map<Integer,Integer> cache) {
	if (cache.containsKey(n)) {
		return cache.get(n);
	}
    if (n == 1 || n == 2) {
      cache.put(n, 1);
      return 1;
    }
    int temp = fs(n-1, cache) + fs(n-2, cache);
    cache.put(n, temp);
    return temp;
  }
}
