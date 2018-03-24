package com.yahoo.util.strings;

public class BaseConversion {

  public static void main(String args[]) {
    System.out.println(convert("FF", 16, 10));
    //int remain = 10;
    //char c =  (char) ((remain - 10) + 'A') ;
    //System.out.println(c);
  }
  
  public static String convert(String value, int frombase, int tobase) {
    StringBuilder builder = new StringBuilder();
    // convert to 
    int fvalue = 0;
    for (int index = 0; index < value.length(); index++) {
      if (value.charAt(index) >= '0' &&  value.charAt(index) <= '9') {
        fvalue *= frombase;
        fvalue +=  (value.charAt(index) - '0') ;
      } else if (value.charAt(index) >= 'A' &&  value.charAt(index) <= 'F') {
        fvalue *= frombase;
        fvalue +=  (value.charAt(index) - 'A' + 10);
      }
    }
    System.out.println(fvalue);
    
    // convert from base 10 to tobase
    System.out.println(convertToBase(fvalue, tobase));
    return builder.toString();
  }

  private static String convertToBase(int fvalue, int tobase) {
    if (fvalue == 0) {
      return "";
    }
    int remain = fvalue % tobase;
    
    return convertToBase(fvalue/tobase, tobase) + ((remain > 9) ? (char) (remain + 'A' - 10) : (""+ remain));
  }
}
