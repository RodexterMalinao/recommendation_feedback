package com.pccw.recommendation.feedback.helper;

public class SQLHelper {

	public static String selectStatement(String columns, String table, String criteria) {
		String selectStatement = "SELECT " + columns + " FROM " + table + " WHERE 1=1 AND " + criteria;
		return selectStatement;
	}

	public static String insertStatement(String columns, String table, String values) {
		String selectStatement = "INSERT INTO " + table + " ( " + columns + " ) VALUES ( " + values + " ) ";
		return selectStatement;
	}

}
