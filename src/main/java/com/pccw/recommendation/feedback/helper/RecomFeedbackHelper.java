package com.pccw.recommendation.feedback.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.google.common.collect.ImmutableList;
import com.pccw.recommendation.feedback.model.RecomFeedback;

public class RecomFeedbackHelper extends SQLHelper {

	public static final String T_RECOM_FB = "RECOMMENDATION_FEEDBACK";

	public static final String F_STAFF_ID = "STAFF_ID";
	public static final String F_STAFF_NAME = "STAFF_NAME";
	public static final String F_FEEDBACK_ID = "FEEDBACK_ID";
	public static final String F_FEEDBACK_DTTM = "FEEDBACK_DTTM";
	public static final String F_FEEDBACK_SYSTEM = "FEEDBACK_SYSTEM";
	public static final String F_PRODUCT_LINES = "PRODUCT_LINES";
	public static final String F_RECOMMENDATION_SOURCE_SYSTEM = "RECOMMENDATION_SOURCE_SYSTEM";
	public static final String F_RECOMMENDED_OFFER = "RECOMMENDED_OFFER";
	public static final String F_FEEDBACK_TYPE = "FEEDBACK_TYPE";
	public static final String F_FEEDBACK_REASON = "FEEDBACK_REASON";
	public static final String F_CLUB_ID = "CLUB_ID";
	public static final String F_PARENT_CUST_NUM = "PARENT_CUST_NUM";
	public static final String F_LINE_LEVEL_KEY = "LINE_LEVEL_KEY";
	public static final String F_LINE_LEVEL_VALUE = "LINE_LEVEL_VALUE";
	public static final String F_CUSTOMER_NUMBER = "CUSTOMER_NUMBER";
	public static final String F_TEAM_ID = "TEAM_ID";
	public static final String F_TEAM_NAME = "TEAM_NAME";
	public static final String F_CHANNEL_CODE = "CHANNEL_CODE";
	public static final String F_CHANNEL_NAME = "CHANNEL_NAME";
	public static final String F_ENABLED_FLAG = "ENABLED_FLAG";

	public static final String ENABLE_FLAG = "Y";
	public static final String DISABLE_FLAG = "N";

	public static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

	public static final ImmutableList<String> mandatoryFields = ImmutableList.of(F_STAFF_ID, F_STAFF_NAME,
			F_FEEDBACK_SYSTEM, F_PRODUCT_LINES, F_RECOMMENDATION_SOURCE_SYSTEM, F_RECOMMENDED_OFFER, F_FEEDBACK_TYPE,
			F_TEAM_ID, F_TEAM_NAME, F_CHANNEL_CODE, F_CHANNEL_NAME, F_PARENT_CUST_NUM, F_LINE_LEVEL_KEY,
			F_LINE_LEVEL_VALUE);

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

	public boolean validateClubId(RecomFeedback recomFeedback) {
		if (recomFeedback.getProductLines().equalsIgnoreCase("CLUB")) {
			if (!StringUtils.isEmpty(recomFeedback.getClubId())) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean validateFeedbackReason(RecomFeedback recomFeedback) {
		if (recomFeedback.getFeedbackType().equalsIgnoreCase("REJECT")) {
			if (!StringUtils.isEmpty(recomFeedback.getFeedbackReason())) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean validateLineLevelKey(RecomFeedback recomFeedback) {
		if (!recomFeedback.getProductLines().equalsIgnoreCase("CLUB")) {
			if (!StringUtils.isEmpty(recomFeedback.getLineLevelKey())) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean validateLineLevelValue(RecomFeedback recomFeedback) {
		if (!recomFeedback.getProductLines().equalsIgnoreCase("CLUB")) {
			if (!StringUtils.isEmpty(recomFeedback.getLineLevelValue())) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean validateParentCustNum(RecomFeedback recomFeedback) {
		if (!recomFeedback.getProductLines().equalsIgnoreCase("CLUB")) {
			if (!StringUtils.isEmpty(recomFeedback.getParentCustNum())) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public static String returnMessageForMandatoryValidation(RecomFeedback recomFeedback) {
		List<String> invFields = new ArrayList<>();

		if (StringUtils.isEmpty(recomFeedback.getStaffId())) {
			invFields.add("staffId");
		}
		if (StringUtils.isEmpty(recomFeedback.getStaffName())) {
			invFields.add("staffName");
		}
		if (StringUtils.isEmpty(recomFeedback.getFeedbackSystem())) {
			invFields.add("feedbackSystem");
		}
		if (StringUtils.isEmpty(recomFeedback.getProductLines())) {
			invFields.add("productLines");
		}
		if (StringUtils.isEmpty(recomFeedback.getRecommendationSourceSystem())) {
			invFields.add("recommendationResourceSystem");
		}
		if (StringUtils.isEmpty(recomFeedback.getRecommendedOffer())) {
			invFields.add("recommendedOffer");
		}
		if (StringUtils.isEmpty(recomFeedback.getFeedbackType())) {
			invFields.add("feedbackType");
		}
		if (StringUtils.isEmpty(recomFeedback.getTeamId())) {
			invFields.add("teamId");
		}
		if (StringUtils.isEmpty(recomFeedback.getTeamName())) {
			invFields.add("teamName");
		}
		if (StringUtils.isEmpty(recomFeedback.getChannelCode())) {
			invFields.add("channelCode");
		}
		if (StringUtils.isEmpty(recomFeedback.getChannelName())) {
			invFields.add("channelName");
		}
		return String.join(",", invFields);
	}

}
