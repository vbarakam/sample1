package com.yahoo.util.java.arrays;

public class InsertDeleteArray {
  public static void main(String args[]) {
   int [] array = new int[]{1, 2, 3, 4, 1, 7, 9, 8, 10};
   printArrays(array);
   
   // insert in position 0
   insert(array, 0, 10);
   printArrays(array);
   
   // insert in position 10
   array = new int[]{1, 2, 3, 4, 1, 7, 9, 8, 10};
   insert(array, 8, 100);
   printArrays(array);
   
   // insert in position 5
   array = new int[]{1, 2, 3, 4, 1, 7, 9, 8, 10};
   insert(array, 5, 100);
   printArrays(array);
   /*
   delete(array, 1);
   for (int index = 0; index < array.length; index++) {
     System.out.print( "  " + array[index]);
   }
   System.out.println("--------------------------");
   array = new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10};
   delete(array, 10);
   for (int index = 0; index < array.length; index++) {
     System.out.print( "  " + array[index]);
   }
   System.out.println("--------------------------");
   array = new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10};

   delete(array, 4);
   for (int index = 0; index < array.length; index++) {
     System.out.print( "  " + array[index]);
   }*/
  }

  private static void insert(int[] array, int pos, int value) {
    for (int index = array.length -2; index >= pos; index--) {
      array[index+1] = array[index]; 
    }
    array[pos] = value; 
  }
  
  private static void delete(int[] array, int i) {
    int deletes  = 0;    
    for (int index = 0; index < array.length; index++) {
      if (array[index] == i) {
        deletes++;
        continue;
      } 
      
      if (deletes > 0) {
        array[index - deletes] = array[index];
      } 
    }
    
    for (int index = array.length - deletes ; index < array.length; index++) {
      array[index] = -1;
    }
    
  }
  
  private static void printArrays(int array[]) {
    for (int index = 0; index < array.length; index++) {
      System.out.print( "  " + array[index]);
    }
    System.out.println("--------------------------");
  }
}
