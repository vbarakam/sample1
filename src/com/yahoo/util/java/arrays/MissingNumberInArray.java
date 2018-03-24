package com.yahoo.util.java.arrays;

import java.util.BitSet;

public class MissingNumberInArray {

  public static void main(String args[]) {
    // one missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

    // two missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

    // three missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

    // four missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

    // Only one missing number in array
    //int[] iArray = new int[]{1, 2, 3, 5};
    //int missing = getMissingNumber(iArray, 5);
    //System.out.printf("Missing number in array %s is %d %n", 
    //                   Arrays.toString(iArray), missing);


  }

  private static void printMissingNumber(int[] is, int count) {
    // create bitset to store the state of the 
    BitSet bitFlags = new BitSet(count);
    System.out.println("size :: " + bitFlags.size());
    // update the bitset vector
    for (int value : is) {
      bitFlags.set(value-1);
    }
    // find the missing number
    int index = 0;
    while (index < count-1) {
      index = bitFlags.nextClearBit(index);
      index += 1;
      //if (index < count)
        System.out.print(" " + index);
    }
    System.out.println(" \nnew line");
  }
}
