package com.yahoo.util3;

import java.util.*;

public class RemoveInvalidParentheses {
	
	public static List<String> removeInvalidParentheses2(String s) {
        List<String> results = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            System.out.println(str);
            if (isValid3(str)) {
                results.add(str);
                found = true;
            }
            
            if (found) {
                continue;
            }
            for (int i = 0; i < str.length(); i++) {
                String temp = str.substring(0,i) + str.substring(i+1);
                if (!visited.contains(temp)) {
                    visited.add(s);
                    queue.add(s);
                }
            }
        }
        return results;
    }
    
    private static boolean isValid3(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                if (c == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0 ? true: false;
    }
    
	public static void main(String args[]) {
		String str = "()())()";
		
		System.out.println(removeInvalidParentheses2(str));
		List<String> results = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		visited.add(str);
		queue.add(str);

		boolean found = false;
		while (!queue.isEmpty()) {
			String po = queue.poll();

			if (isValid(po)) {
				results.add(po);
				found = true;
				continue;
			}
			
			if (found) {
				continue;
			}

			for (int i = 0; i < po.length(); i++) {
				if (po.charAt(i) != '(' && po.charAt(i) != ')')
					continue;
				String s = po.substring(0, i) + po.substring(i + 1);
				if (!visited.contains(s)) {
					queue.add(s);
					visited.add(s);
				}
			}
		}

		System.out.println(results);
	}

	private static boolean isValid(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				count++;
			} else if (str.charAt(i) == ')') {
				if (count == 0)
					return false;
				count--;
			}

		}

		return count == 0 ? true : false;
	}
	
	public static List<String> removeInvalidParentheses(String s) {
	      List<String> res = new ArrayList<>();
	      
	      // sanity check
	      if (s == null) return res;
	      
	      Set<String> visited = new HashSet<>();
	      Queue<String> queue = new LinkedList<>();
	      
	      // initialize
	      queue.add(s);
	      visited.add(s);
	      
	      boolean found = false;
	      
	      while (!queue.isEmpty()) {
	        s = queue.poll();
	        
	        if (isValid(s)) {
	          // found an answer, add to the result
	          res.add(s);
	          found = true;
	        }
	      
	        if (found) continue;
	      
	        // generate all possible states
	        for (int i = 0; i < s.length(); i++) {
	          // we only try to remove left or right paren
	          if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
	        
	          String t = s.substring(0, i) + s.substring(i + 1);
	        
	          if (!visited.contains(t)) {
	            // for each state, if it's not visited, add it to the queue
	            queue.add(t);
	            visited.add(t);
	          }
	        }
	      }
	      
	      return res;
	    }
	    
	    // helper function checks if string s contains valid parantheses
	    boolean isValid2(String s) {
	      int count = 0;
	    
	      for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c == '(') count++;
	        if (c == ')' && count-- == 0) return false;
	      }
	    
	      return count == 0; 
	    }
}
