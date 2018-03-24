package com.yahoo.util.bits;

public class NextPowerOf2 {

	public int nextPower(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}

		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}

		return num << 1;
	}

	public static void main(String[] args) {
		NextPowerOf2 power = new NextPowerOf2();
		for (int i = 1; i < 100; i++) {
			double val = (power.nextPower(i) * 2 -1)/(i * 1.0);
			if (val > 3) 
				System.out.println(i + " :: " + power.nextPower(i) + " :: " + (power.nextPower(i) * 2 -1) + " :: "  +  val);

		}
	}
}
