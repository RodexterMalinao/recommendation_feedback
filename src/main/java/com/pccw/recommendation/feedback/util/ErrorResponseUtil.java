package com.pccw.recommendation.feedback.util;

import java.util.HashMap;

public final class ErrorResponseUtil {

	public static final HashMap<Integer, String> responseCodes = new HashMap<>();

	public static final String STATUS_CODE_MANDATORY = "600";

	static {
		responseCodes.put(600, "The following fields are required : ");
//		responseCodes.put(3, "thirty");
//		responseCodes.put(4, "forty");
//		responseCodes.put(5, "fifty");
//		responseCodes.put(6, "sixty");
//		responseCodes.put(7, "seventy");
//		responseCodes.put(8, "eighty");
//		responseCodes.put(9, "ninety");
	}

}