package com.pccw.recommendation.feedback.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.google.common.collect.ImmutableList;
import com.pccw.recommendation.feedback.model.RecomFeedback;

public class RecomFeedbackHelper extends SQLHelper {

	public static final String T_RECOM_FB = "recommendation_feedback";

	public static final String F_STAFF_ID = "staff_id";
	public static final String F_STAFF_NAME = "staff_name";
	public static final String F_FEEDBACK_ID = "feedback_id";
	public static final String F_FEEDBACK_DTTM = "feedback_dttm";
	public static final String F_FEEDBACK_SYSTEM = "feedback_system";
	public static final String F_PRODUCT_LINES = "product_lines";
	public static final String F_RECOMMENDATION_SOURCE_SYSTEM = "recommendation_source_system";
	public static final String F_RECOMMENDED_OFFER = "recommended_offer";
	public static final String F_FEEDBACK_TYPE = "feedback_type";
	public static final String F_FEEDBACK_REASON = "feedback_reason";
	public static final String F_CLUB_ID = "club_id";
	public static final String F_PARENT_CUST_NUM = "parent_cust_num";
	public static final String F_LINE_LEVEL_KEY = "line_level_key";
	public static final String F_LINE_LEVEL_VALUE = "line_level_value";
	public static final String F_CUSTOMER_NUMBER = "customer_number";
	public static final String F_TEAM_ID = "team_id";
	public static final String F_TEAM_NAME = "team_name";
	public static final String F_CHANNEL_CODE = "channel_code";
	public static final String F_CHANNEL_NAME = "channel_name";
	public static final String F_ENABLED_FLAG = "enabled_flag";

	public static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

	public static final ImmutableList<String> mandatoryFields = ImmutableList.of(F_STAFF_ID, F_STAFF_NAME,
			F_FEEDBACK_SYSTEM, F_PRODUCT_LINES, F_RECOMMENDATION_SOURCE_SYSTEM, F_RECOMMENDED_OFFER, F_FEEDBACK_TYPE,
			F_TEAM_ID, F_TEAM_NAME, F_CHANNEL_CODE, F_CHANNEL_NAME);

	public boolean isMandatoryValid(RecomFeedback recomFeedback) {

		if (StringUtils.isEmpty(recomFeedback.getStaffId())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getStaffName())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getFeedbackSystem())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getProductLines())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getRecommendationSourceSystem())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getRecommendedOffer())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getFeedbackType())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getTeamId())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getTeamName())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getChannelCode())) {
			return false;
		}
		if (StringUtils.isEmpty(recomFeedback.getChannelName())) {
			return false;
		}
		return true;
	}

	public static String returnMessageForMandatoryValidation(RecomFeedback recomFeedback) {
		List<String> invFields = new ArrayList<>();

		if (StringUtils.isEmpty(recomFeedback.getStaffId())) {
			invFields.add(F_STAFF_ID);
		}
		if (StringUtils.isEmpty(recomFeedback.getStaffName())) {
			invFields.add(F_STAFF_NAME);
		}
		if (StringUtils.isEmpty(recomFeedback.getFeedbackSystem())) {
			invFields.add(F_FEEDBACK_SYSTEM);
		}
		if (StringUtils.isEmpty(recomFeedback.getProductLines())) {
			invFields.add(F_PRODUCT_LINES);
		}
		if (StringUtils.isEmpty(recomFeedback.getRecommendationSourceSystem())) {
			invFields.add(F_RECOMMENDATION_SOURCE_SYSTEM);
		}
		if (StringUtils.isEmpty(recomFeedback.getRecommendedOffer())) {
			invFields.add(F_RECOMMENDED_OFFER);
		}
		if (StringUtils.isEmpty(recomFeedback.getFeedbackType())) {
			invFields.add(F_FEEDBACK_TYPE);
		}
		if (StringUtils.isEmpty(recomFeedback.getTeamId())) {
			invFields.add(F_TEAM_ID);
		}
		if (StringUtils.isEmpty(recomFeedback.getTeamName())) {
			invFields.add(F_TEAM_NAME);
		}
		if (StringUtils.isEmpty(recomFeedback.getChannelCode())) {
			invFields.add(F_CHANNEL_CODE);
		}
		if (StringUtils.isEmpty(recomFeedback.getChannelName())) {
			invFields.add(F_CHANNEL_NAME);
		}
		return String.join(",", invFields);
	}

}
