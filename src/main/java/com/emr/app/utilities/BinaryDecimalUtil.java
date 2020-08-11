package com.emr.app.utilities;

public class BinaryDecimalUtil {

	public static boolean[] decToBinary(int dec) {
		boolean[] binary = new boolean[7];
		int i = 6;
		while (dec != 0) {
			if (dec % 2 == 1) {
				binary[i] = true;
			} else {
				binary[i] = false;
			}
			i--;
			dec = dec / 2;
		}
		return binary;
	}

	public static int binaryToDec(boolean[] binary) {
		int dec = 0;
		int n = binary.length;
		for (int i = 0; i < n; i++) {
			if (binary[i]) {
				dec += Math.pow(2, n - i - 1);
			}
		}
		return dec;
	}
}