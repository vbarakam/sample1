npackage com.yahoo.util.graph;

import java.util.Stack;

public class ValidParam {
	public static void main(String args[]) {
		String str = "()";
		System.out.println(longestValidParentheses(str));
	}
	
	public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        //(() : error, add, pop
        //)()()) : error, Add,Pop, Add,Pop,Error 
        //()(() : Add,Pop,Add,Add,pop
        // (((()))) : Add,Add,Add,Add,Pop,Pop,pop,pop
        // ()()()
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // check if char is open char and check if top is open char
            if (chars[i] == ')' && !stack.empty() && chars[stack.peek()] == '(') {
                stack.pop();
            } else {
            	stack.push(i);
            }
        }
        int max = 0;
        if (stack.empty()) {
            max = s.length();
        } else {
            int high = s.length() + 1;
            int low = 0;
            while (!stack.empty()) {
                int temp = high - (stack.peek() + 1) - 1;
                high = stack.peek() + 1;
                low = stack.pop();
                if (temp > max) {
                    max = temp;
                }
            }
            
            if (low != 0) {
                int temp = high - 1;
                if (temp > max) {
                    max = temp;
                }
            }
        }

        
        return max;
    }
}
