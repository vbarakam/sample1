package com.yahoo.util3;

import java.util.*;

public class MovingAverage {
	public static void main(String args[]) {
		List<Integer> data = new ArrayList<>();
		data.add(10);
		data.add(20);
		System.out.println(data);
		MovingAverage2 avg = new MovingAverage2(3);
		System.out.println(avg.next(1));
		System.out.println(avg.next(10));
		System.out.println(avg.next(3));
		System.out.println(avg.next(5));
	}
}

class MovingAverage2 {
    private int sum = 0;
    private int count = 0;
    private int size = 0;
    private List<Integer> numbers = new ArrayList<>();

    /** Initialize your data structure here. */
    public MovingAverage2(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if (numbers.size() + 1 > size) {
            // remove the last number
            sum -= numbers.get(numbers.size()-1); 
            numbers.remove(numbers.size()-1);
            numbers.add(val);
            sum += val;
            return sum/(count * 1.0);
        } else {
            sum += val;
            count += 1;
            numbers.add(val);
            return sum/(count * 1.0);
        }
    }
}