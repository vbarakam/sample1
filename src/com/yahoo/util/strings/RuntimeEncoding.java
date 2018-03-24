package com.yahoo.util.strings;

public class RuntimeEncoding {

  public static void main(String args[]) {
   //String encodeExample = "aaaabcccaa";
   String encodeExample = "abaabcccaa";
   System.out.println(encode(encodeExample));
   
   String decodeExample = "3e4f100e"; // eeeffffee
   System.out.println(decode(decodeExample));
  }
  
  public static String encode(String input) {
    // validate the input
    if (input.length() == 0) {
      return "";
    }
    
    StringBuilder builder = new StringBuilder();
    int index = 1;
    int bufferIndex = 1;
    builder.append(1);
    builder.append(input.charAt(0));
    while (index < input.length()) {
      if (builder.charAt(bufferIndex) == input.charAt(index)) {
        builder.setCharAt((bufferIndex -1), (char) (builder.charAt(bufferIndex-1) + 1));
      } else {
        builder.append(1);
        builder.append(input.charAt(index));
        bufferIndex = bufferIndex + 2;
      }
      
      index++;
    }

    return builder.toString();
  }
  
  public static String decode(String input) {
    int index = 0;
    StringBuilder build = new StringBuilder();
    int number = 0;
    while (index < input.length()) {
      if (input.charAt(index) >= '0' && input.charAt(index) <= '9') {
        int temp = input.charAt(index) - '0'; 
        if (number > 0) {
           number = number * 10 + temp;
        } else {
          number = temp;
        }
      } else {
        // not a number
        for (int i = 0 ; i < number; i++) {
          build.append(input.charAt(index));
        }
        number = 0;
      }
      index++;
    }
    return build.toString();
  }
}
