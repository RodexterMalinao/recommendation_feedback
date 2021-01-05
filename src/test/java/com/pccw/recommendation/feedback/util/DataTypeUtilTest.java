package com.pccw.recommendation.feedback.util;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public final class DataTypeUtilTest {

	@Test
	public void contextLoads() {

		@SuppressWarnings("deprecation")
		String dateStr = DataTypeUtil.dateAsString(new Date("2021/01/01 12:12:12"), "MM-dd-yyyy");
		assertEquals("01-01-2021", dateStr);

		String numStr = DataTypeUtil.integerAsString(123);
		assertEquals("123", numStr);

		Integer strNum = DataTypeUtil.stringAsInteger("456");
		assertEquals(strNum, Integer.valueOf(456));
	}

}