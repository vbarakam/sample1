package com.yahoo.util.strings;

import java.util.ArrayList;
import java.util.List;

public class PhoneMnemonics {
  private static final String [] MAPPING = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
  
  public static void main(String args[]) {
    String phoneNumber = "2276696";
    
    List<String> temp = new ArrayList<String>();
    temp.add(phoneNumber);
    List<String> mnemonics = generateMnemonics(temp, 0);
    System.out.println(mnemonics.size());
  }

  private static List<String> generateMnemonics(List<String> phoneNumbers, int index) {
   
    // define exit criteria
    if (index >= phoneNumbers.get(0).length()) {
      return phoneNumbers;
    }

    // for each of the phone number in the list replace index char with mapped chars
    List<String> temp1 = new ArrayList<String>();
    for (String phoneNumber : phoneNumbers) {
      int m = (int) phoneNumber.charAt(index) - 48;
      String nMapping = PhoneMnemonics.MAPPING[m];
      char array [] = phoneNumber.toCharArray();
      for (char c : nMapping.toCharArray()) {
        array[index] = c;
        temp1.add(new String(array));
        System.out.println(" :: " + new String(array));
      }
    }
    return generateMnemonics(temp1, index + 1);
  }
  
  private static List<String> generateMnemonics2(String phoneNumber) {
    List<String> temp = new ArrayList<String>();
    temp.add(phoneNumber);
    int counter = 0;
    
    for (int index = 0; index < phoneNumber.length(); index++) {
      int m = (int) phoneNumber.charAt(index) - 48;
      String nMapping = PhoneMnemonics.MAPPING[m];
      List<String> temp1 = new ArrayList<String>();
    
      for (String mn : temp) {
        char array [] = mn.toCharArray();
        for (char c : nMapping.toCharArray()) {
          array[index] = c;
          temp1.add(new String(array));
          System.out.println(counter++ + " :: " + new String(array));
        }
      }
      temp.clear();
      temp.addAll(temp1);
      temp1.clear();
    }
    System.out.println("Total mnemonics " + temp.size() );
    return temp;
  }

}
