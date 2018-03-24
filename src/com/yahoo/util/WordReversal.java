package com.yahoo.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WordReversal {

  public static void main(String args[]) {
    String message = "venkat kumar reddy barakam";
    queue(message);
  }
  
  private static void queue(String message) {
    Queue<Character> queue = new ConcurrentLinkedQueue<Character>();
    StringBuilder b = new StringBuilder();
    int endIndex = message.length();
    for (int index = message.length()-1; index >= 0; index--) {
      char c = message.charAt(index);
      if (c == ' ') {
        b.append(message.substring(index+1, endIndex));
        b.append(' ');
        endIndex = index+1;
        continue;
      }
    }
    b.append(message.substring(0, endIndex-1));
    b.append("#");
    System.out.println(b.reverse().toString());
  }
  
  private static void queue2(String message) {
    Queue<Character> queue = new ConcurrentLinkedQueue<Character>();
    StringBuilder b = new StringBuilder();
    int endIndex = message.length();
    for (int index = message.length()-1; index >= 0; index--) {
      char c = message.charAt(index);
      if (c == ' ') {
        //b.append(message.substring(index+1, endIndex));
        b.append(' ');
        endIndex = index+1;
        continue;
      } else {
        b.append(c);
      }
    }
    b.append(message.substring(0, endIndex-1));
    b.append("#");
    System.out.println(b.reverse().toString());
  }
  
  private static void split(String message) {
    String splits[] = message.split(" ");
    for (int index = splits.length-1; index >=0; index--) {
      System.out.println(splits[index]);
    }
  }
}
