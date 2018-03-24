package com.yahoo.util.sorting;

public class Shadow2 {

  public int x = 1;
  
  public void method(int x) {
    System.out.println(" method x : " + x);
    System.out.println(" instance x : " + this.x);
  }
  
  public static void main(String args[]) {
    Shadow2 ss = new Shadow2();
    ss.method(10);
  }
}
