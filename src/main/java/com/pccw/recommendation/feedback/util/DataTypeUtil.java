package com.pccw.recommendation.feedback.util;

import java.text.SimpleDateFormat;

public final class DataTypeUtil {

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