package com.emr.app.utilities;

import java.util.regex.Pattern;

import com.google.common.base.Strings;

public class InputValidator {

	private static final String CONTACT_REGEX = "^\\d{10}$";
	private static final String AGE_REGEX = "^\\d*$";
	private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

	private static Pattern pattern;

	public static boolean validateContactNo(String contactNo) {
		pattern = Pattern.compile(CONTACT_REGEX);
		return (Strings.isNullOrEmpty(contactNo) || !pattern.matcher(contactNo).matches());
	}

	public static boolean validateAge(String age) {
		pattern = Pattern.compile(AGE_REGEX);
		return (Strings.isNullOrEmpty(age) || !pattern.matcher(age).matches());
	}

	public static boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_REGEX);
		return (Strings.isNullOrEmpty(email) && !pattern.matcher(email).matches());
	}

	public static boolean validateString(String value) {
		return Strings.isNullOrEmpty(value);
	}

	public static boolean isFloat(String value) {
		if (Strings.isNullOrEmpty(value)) {
			return true;
		}
		try {
			Float.parseFloat(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static boolean isInteger(String value) {
		if (Strings.isNullOrEmpty(value)) {
			return false;
		}
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
