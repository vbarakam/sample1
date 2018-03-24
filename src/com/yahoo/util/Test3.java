package com.yahoo.util;

import java.util.*;

public class Test3 {

  public static void main(String args[]) {
	  Map<String, Object> stats = new HashMap<>();
	  stats.put("a", 1);
	  Map<String, Object> bstats = new HashMap<>();
	  bstats.put("ba", 3);
	  bstats.put("bb", 4);
	  stats.put("b", bstats);
	  stats.put("c", 1);
	  Map<String, Object> cstats = new HashMap<>();
	  cstats.put("ca", 3);
	  Map<String, Object> ccstats = new HashMap<>();
	  ccstats.put("xba", 3);
	  ccstats.put("cbb", 4);
	  cstats.put("cb",ccstats);
	  stats.put("d", cstats);
	  stats.put("e", 1);
	  print("", stats);
  }
  
  private static void print(String prefix, Map<String, Object> cstats) {
	  for (Map.Entry entry : cstats.entrySet()) {
		  if (entry.getValue() instanceof Map) {
			  print(prefix + entry.getKey() + "->", (Map) entry.getValue());
		  } else {
			  System.out.println(prefix + entry.getKey() + "->" + entry.getValue());
		  }
	  }
  }
}
