package com.yahoo.util.sorting;

import java.util.BitSet;


public class BitSetTest {

  public static void main(String args[]) {
    BitSet bSet = new BitSet();
    for (int index = 0; index < 10; index++) {
      System.out.println(bSet.get(index));
    }
  }
}
