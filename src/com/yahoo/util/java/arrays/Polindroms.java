package com.yahoo.util.java.arrays;

public class Polindroms {

  public static void main(String args[]) {
    String example1 = "race car";
    String example2 = "step on no pets";
    String example3= "reliefpfpfeiller";
    System.out.println(isStringPolindrome(example3));
  }
  
  public static boolean isStringPolindrome(String input) {
    for (int start = 0, end = input.length() -1; start < end; start++,end--) {
      if (input.charAt(start) == ' ') {
        start++;
      }
      if (input.charAt(end) == ' ') {
        end--;
      }
      System.out.println(" start :: " + start + " end :: " + end);
      if (input.charAt(start) != input.charAt(end)) {
        return false;
      }  
    }
    return true;
  }
  
  // recursion
  public static boolean isStringPolindrome(String input, int start, int end) {
    if (start < end) {
      
    }
  }
}
