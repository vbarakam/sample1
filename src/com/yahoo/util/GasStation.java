package com.yahoo.util;

public class GasStation {
	public static void main(String args[]) {
		//int [] gas = {1,2};
		//int [] cost = {2,1};
		
		int [] gas = {1,2,3,3};
		int [] cost	= {2,1,5,1};
		System.out.println(canCompleteCircuit(gas, cost));
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int index = 0;
        int subtotal = 0;
        while (index < gas.length) {
        	total += gas[index] - cost[index];
          
            if (total < subtotal) {
            	subtotal = total;
            	start = index + 1;
            }
            index++;
        }
        return (total) < 0 ? -1 : (start % gas.length);
    }
}
