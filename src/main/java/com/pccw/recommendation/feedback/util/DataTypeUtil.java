package com.pccw.recommendation.feedback.util;

import java.text.SimpleDateFormat;

public final class DataTypeUtil {
	// Example Utility method
	public static int foo(int i, int j) {
		int val = 0;
		// Do stuff
		return val;
	}

	// Example Utility method overloaded
	public static float foo(float i, float j) {
		float val = 0;
		// Do stuff
		return val;
	}

	// Example Utility method calling private method
	public static long bar(int p) {
		return hid(p) * hid(p);
	}

	// Example private method
	private static long hid(int i) {
		return i * 2 + 1;
	}

	public static String dateAsString(Object date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateAsString = sdf.format(date);
		return dateAsString;
	}

	public static String integerAsString(Object num) {
		return String.valueOf(num);
	}

	public static int stringAsInteger(Object val) {
		return Integer.valueOf(val.toString());
	}
}