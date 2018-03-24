package com.yahoo.util;

import java.util.HashMap;
import java.util.Map;

public class String2Integer {
  private static Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();

  static {
    mapping.put(1, 1);
    mapping.put(2, 100);
    mapping.put(3, 1000);
    mapping.put(4, 10000);
    mapping.put(5, 100000);
    mapping.put(6, 1000000);
    mapping.put(7, 10000000);
    mapping.put(8, 100000000);
  }

  public static void main(String args[]) {
    // think about double value
    String message1 = "12345";
    String message2 = "-12345";
    int2String(12345);
    //parseInt(message1);
    //parseInt(message2);
  }

  private static void int2String(int message) {
    StringBuilder str = new StringBuilder();
    boolean isNegative = false;
    if (message < 0) {
      isNegative = true;
      //str.append("-");
      message *= -1;
    }
    while (message > 0) {
      int mod = message % 10;
      str.append(mod);
      message = message/10;
    }
   
    str.reverse();
    
    if (isNegative){
      str.insert(0, '-');
    }
    
    System.out.println(str.toString());
  }
  
  private static void parseInt(String message) {
    // check if the string contains - in first position
    boolean isNegative = message.charAt(0) == '-' ? true : false;
    int value = 0;
    for (int index = (isNegative ? 1 : 0); index < message.length(); index++) {
      char c = message.charAt(index);
      if (c >= '0' && c <= '9') {
        int temp = (int) c - 48;
        value = value * 10 + temp;
      } else {
        throw new IllegalArgumentException();
      }
    }

    if (isNegative) {
      value *= -1;
    }
    System.out.println(value);
  }


  private static void parseString(String message) {
    System.out.println(message);
    // validate the input

    // check if the string contains - in first position
    boolean negativeNumber = message.charAt(0) == '-' ? true : false;
    double value = 0;
    int length = message.length();
    boolean decimal = false;
    int decimalPosition = -1;
    for (int index = (negativeNumber ? 1 : 0); index < length; index++) {
      char c = message.charAt(index);
      if (c >= '0' && c <= '9') {
        int temp = (int) c - 48;
        int powd = length - index - 1 + (decimal ? 1 : 0);
        int factor = (int) Math.pow(10, powd);
        temp = temp * factor;
        value = value + temp;
        // System.out.println(temp);
      } else if (c == '.') {
        decimal = true;
        decimalPosition = index;
      } else {
        throw new IllegalArgumentException();
      }
    }

    if (negativeNumber) {
      value *= -1;

    }
    if (decimal) {
      value = value / Math.pow(10, (length - decimalPosition));
    }
    System.out.println(value);
  }
}
