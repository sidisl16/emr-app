package com.emr.app.utilities;

public class AppUtil {

	public static int getHammingDistance(String s1, String s2) {

		int distance = 0;
		if (s1.length() > s2.length()) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				distance++;
			}
		}
		return distance;
	}
}
