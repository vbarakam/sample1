package com.yahoo.util.strings;

public class SpreadsheetColumnEncoding {

  public static void main(String args[]) {
    String input = "ZZZ";
    System.out.println(encode(input));
  }
  
  public static double encode(String input) {
    double value = 0;
    int pw = input.length()-1;
    for (int index = 0 ; index < input.length(); index++) {
      value += ((input.charAt(index) - 'A' ) + 1) * Math.pow(26, pw--);
    }
    return value;
  }
}
