package com.yahoo.util;

import java.util.*;

public class BasicCalculator {
	public static void main(String args[]) {
		String str = "0-2147483647";
		System.out.println(calculate4(str));
		/*List<Integer> data = new ArrayList<>();
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(data.size(), 4);*/
	}
	
	public static int calculate4(String s) {
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == s.length() -1 ) {
                 if (lastSign == '+') {
                    stack.push(sign * num);
                    sign = 1;
                    num = 0;
                } else if (lastSign == '-') {
                    stack.push(sign * num);
                    sign = -1;
                    num = 0;
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * num);
                    num = 0;
                      sign = 1;
                } else if (lastSign == '/') {
                    stack.push(stack.pop() / num);
                    num = 0;
                      sign = 1;
                }
                if (i != s.length() -1) {
                    lastSign = ch;
                    if (lastSign == '+') {
                        stack.push(sign * num);
                        sign = 1;
                        num = 0;
                    } else if (lastSign == '-') {
                        stack.push(sign * num);
                        sign = -1;
                        num = 0;
                    }
                }else
                    break;
            }
        }
        int temp = 0;
        while (!stack.isEmpty()) {
            temp += stack.pop();
        }
        return temp;
    }

	public static int calculate3(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                num = 0;
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * num;
                result = stack.pop() * result;
                result += stack.pop();
                sign = 1;
                num = 0;
            }
        }
        if (num != 0) {
            result += sign * num;
        }

        return result;       
    }
	
	// "3+2*2" = 7
	// "" = 1
	// " 3+5 / 2 " = 5
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int number = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				number = number * 10 + (s.charAt(i) - '0');
			}

			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == s.length()-1) {
				if (sign == '+') {
					stack.push(number);
				} else if (sign == '-') {
					stack.push(-number);
				} else if (sign == '/') {
					stack.push(stack.pop() / number);
				} else if (sign == '*') {
					stack.push(stack.pop() * number);
				}
				number = 0;
				sign = s.charAt(i);
			}
		}

		int result = 0;
		for (Integer ss : stack) {
			result += ss;
		}

		return result;
	}

	public static int calculate2(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int sign = 1;
		int result = 0;
		int number = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				number = number * 10 + (s.charAt(i) - '0');
			} else if (s.charAt(i) == '+') {
				result += sign * number;
				number = 0;
				sign = 1;
			} else if (s.charAt(i) == '-') {
				result += sign * number;
				number = 0;
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				number = 0;
				sign = 1;
				result = 0;
			} else if (s.charAt(i) == ')') {
				result += sign * number;
				result *= stack.pop();
				result += stack.pop();
				number = 0;
				sign = 1;
			}
		}
		if (number != 0) {
			result += sign * number;
		}

		return result;
	}
}
