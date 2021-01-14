package com.pccw.recommendation.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

import com.pccw.recommendation.feedback.helper.RecomFeedbackHelper;
import com.pccw.recommendation.feedback.model.RecomFeedback;
import com.pccw.recommendation.feedback.model.RecomFeedbackPost;
import com.pccw.recommendation.feedback.response.Data;
import com.pccw.recommendation.feedback.response.RecomFeedbackHistory;
import com.pccw.recommendation.feedback.response.ResponseMessage;
import com.pccw.recommendation.feedback.util.DataTypeUtil;
import com.pccw.recommendation.feedback.util.ErrorResponseUtil;

import net.javacrumbs.jsonunit.core.internal.JsonUtils;

@Service("recomFeedbackService")
public class RecomFeedbackServiceImpl extends RecomFeedbackHelper implements RecomFeedbackService {

	@Override
	public List<RecomFeedback> retrieveRecomFeedback(Exchange xchg) {
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn().getBody();
		List<RecomFeedback> recomFeedbacks = new ArrayList<RecomFeedback>();

		for (Map<String, String> data : dataList) {
			RecomFeedback recomFeedback = new RecomFeedback();
			recomFeedback.setFeedbackId(DataTypeUtil.stringAsInteger(data.get(F_FEEDBACK_ID)));
			recomFeedback.setFeedbackDttm(String.valueOf(data.get(F_FEEDBACK_DTTM)));
			recomFeedback.setFeedbackSystem(data.get(F_FEEDBACK_SYSTEM));
			recomFeedback.setRecommendationSourceSystem(data.get(F_RECOMMENDATION_SOURCE_SYSTEM));
			recomFeedback.setRecommendedOffer(data.get(F_RECOMMENDED_OFFER));
			recomFeedback.setFeedbackType(data.get(F_FEEDBACK_TYPE));
			recomFeedback.setFeedbackReason(data.get(F_FEEDBACK_REASON));
			recomFeedback.setProductLines(data.get(F_PRODUCT_LINES));
			recomFeedback.setClubId(data.get(F_CLUB_ID));
			recomFeedback.setParentCustNum(data.get(F_PARENT_CUST_NUM));
			recomFeedback.setLineLevelKey(data.get(F_LINE_LEVEL_KEY));
			recomFeedback.setLineLevelValue(data.get(F_LINE_LEVEL_VALUE));
			recomFeedback.setCustomerNumber(data.get(F_CUSTOMER_NUMBER));
			recomFeedback.setStaffId(data.get(F_STAFF_ID));
			recomFeedback.setStaffName(data.get(F_STAFF_NAME));
			recomFeedback.setTeamId(data.get(F_TEAM_ID));
			recomFeedback.setTeamName(data.get(F_TEAM_NAME));
			recomFeedback.setChannelCode(data.get(F_CHANNEL_CODE));
			recomFeedback.setChannelName(data.get(F_CHANNEL_NAME));
			recomFeedback.setEnabledFlag(data.get(F_ENABLED_FLAG));
			recomFeedbacks.add(recomFeedback);
		}

		return recomFeedbacks;
	}

	@Override
	public void selectRecomFeedback(Exchange xchg) {
		String parentCustNum = String.valueOf(xchg.getIn().getHeader("parentCustNum").toString());
		String productLines = String.valueOf(xchg.getIn().getHeader("productLines").toString());
		String clubId = String.valueOf(xchg.getIn().getHeader("clubId").toString());

		String columns = "DISTINCT " + F_FEEDBACK_ID + "," + F_FEEDBACK_DTTM + "," + F_FEEDBACK_SYSTEM + ","
				+ F_RECOMMENDATION_SOURCE_SYSTEM + "," + F_RECOMMENDED_OFFER + "," + F_FEEDBACK_TYPE + ","
				+ F_FEEDBACK_REASON + "," + F_PRODUCT_LINES + "," + F_CLUB_ID + "," + F_PARENT_CUST_NUM + ","
				+ F_LINE_LEVEL_KEY + "," + F_LINE_LEVEL_VALUE + "," + F_CUSTOMER_NUMBER + "," + F_STAFF_ID + ","
				+ F_STAFF_NAME + "," + F_TEAM_ID + "," + F_TEAM_NAME + "," + F_CHANNEL_CODE + "," + F_CHANNEL_NAME + ","
				+ F_ENABLED_FLAG;

		String criteria = F_PRODUCT_LINES + " = " + "'" + productLines + "'" + " and " + "( " + F_CLUB_ID + " = " + "'"
				+ clubId + "'" + " or " + F_PARENT_CUST_NUM + " = " + "'" + parentCustNum + "'" + " )" + " and "
				+ F_ENABLED_FLAG + " = " + "'" + ENABLE_FLAG + "' order by " + F_FEEDBACK_DTTM + " DESC";

		String query = selectStatement(columns, T_RECOM_FB, criteria);

		System.out.println("query : " + query);

		xchg.getIn().setBody(query);

	}

	@Override
	public void insertRecomFeedback(Exchange xchg) {

		RecomFeedbackPost recomFeedbackPost = xchg.getIn().getBody(RecomFeedbackPost.class);
		RecomFeedback recomFeedback = new RecomFeedback(recomFeedbackPost);

		String columns = F_FEEDBACK_SYSTEM + "," + F_RECOMMENDATION_SOURCE_SYSTEM + "," + F_RECOMMENDED_OFFER + ","
				+ F_FEEDBACK_TYPE + "," + F_FEEDBACK_REASON + "," + F_PRODUCT_LINES + "," + F_CLUB_ID + ","
				+ F_PARENT_CUST_NUM + "," + F_LINE_LEVEL_KEY + "," + F_LINE_LEVEL_VALUE + "," + F_CUSTOMER_NUMBER + ","
				+ F_STAFF_ID + "," + F_STAFF_NAME + "," + F_TEAM_ID + "," + F_TEAM_NAME + "," + F_CHANNEL_CODE + ","
				+ F_CHANNEL_NAME;

		String values = "'" + recomFeedback.getFeedbackSystem() + "','" + recomFeedback.getRecommendationSourceSystem()
				+ "','" + recomFeedback.getRecommendedOffer() + "','" + recomFeedback.getFeedbackType() + "','"
				+ recomFeedback.getFeedbackReason() + "','" + recomFeedback.getProductLines() + "','"
				+ recomFeedback.getClubId() + "','" + recomFeedback.getParentCustNum() + "','"
				+ recomFeedback.getLineLevelKey() + "','" + recomFeedback.getLineLevelValue() + "','"
				+ recomFeedback.getCustomerNumber() + "','" + recomFeedback.getStaffId() + "','"
				+ recomFeedback.getStaffName() + "','" + recomFeedback.getTeamId() + "','" + recomFeedback.getTeamName()
				+ "','" + recomFeedback.getChannelCode() + "','" + recomFeedback.getChannelName() + "'";

		String query = insertStatement(columns, T_RECOM_FB, values);

		System.out.println("query : " + query);

		xchg.getIn().setBody(query);
	}

	@Override
	public void returnId(Exchange xchg) {
		RecomFeedbackPost recomFeedbackPost = xchg.getIn().getBody(RecomFeedbackPost.class);
		RecomFeedback recomFeedback = new RecomFeedback(recomFeedbackPost);

		String criteria = F_CLUB_ID + " = " + "'" + recomFeedback.getClubId() + "'" + " and " + F_CUSTOMER_NUMBER + " ="
				+ "'" + recomFeedback.getCustomerNumber() + "'" + " and " + F_FEEDBACK_SYSTEM + " =" + "'"
				+ recomFeedback.getFeedbackSystem() + "'" + " and " + F_RECOMMENDATION_SOURCE_SYSTEM + " =" + "'"
				+ recomFeedback.getRecommendationSourceSystem() + "'" + " and " + F_RECOMMENDED_OFFER + " =" + "'"
				+ recomFeedback.getRecommendedOffer() + "'" + " and " + F_FEEDBACK_TYPE + " =" + "'"
				+ recomFeedback.getFeedbackType() + "'" + " and " + F_FEEDBACK_REASON + " =" + "'"
				+ recomFeedback.getFeedbackReason() + "'" + " and " + F_PRODUCT_LINES + " =" + "'"
				+ recomFeedback.getProductLines() + "'" + " and " + F_STAFF_ID + " =" + "'" + recomFeedback.getStaffId()
				+ "'" + " and " + F_STAFF_NAME + " =" + "'" + recomFeedback.getStaffName() + "'" + " and " + F_TEAM_ID
				+ " =" + "'" + recomFeedback.getTeamId() + "'" + " and " + F_TEAM_NAME + " =" + "'"
				+ recomFeedback.getTeamName() + "'" + " and " + F_CHANNEL_CODE + " =" + "'"
				+ recomFeedback.getChannelCode() + "'" + " and " + F_CHANNEL_NAME + " =" + "'"
				+ recomFeedback.getChannelName() + "' ORDER BY " + F_FEEDBACK_ID + " DESC LIMIT 1";

		String query = selectStatement(F_FEEDBACK_ID, T_RECOM_FB, criteria);

		System.out.println("select query : " + query);
		xchg.getIn().setBody(query);
	}

	@Override
	public void printSuccessResponseMessage(Exchange xchg) {

		ResponseMessage responseMessage = new ResponseMessage();
		Data data = new Data();

		String value = xchg.getIn().getHeader("feedbackHistory", String.class);
		String feedbackId = xchg.getIn().getHeader("feedbackId", String.class);

		if (value != null) {
			switch (value) {
			case "T":
				List<RecomFeedbackHistory> recomFeedbacks = new ArrayList<RecomFeedbackHistory>();
				recomFeedbacks = getRecomFeedbackList(xchg);
				responseMessage.setStatus(200);
				responseMessage.setSuccess(true);
				responseMessage.setMessage("Insert record with feedback history");
				data.setFeedbackId(feedbackId);
				data.setHistory(recomFeedbacks);
				responseMessage.setData(data);
				break;
			default:
				responseMessage.setStatus(200);
				responseMessage.setSuccess(true);
				responseMessage.setMessage("Insert record without feedback history");
				data.setFeedbackId(feedbackId);
				responseMessage.setData(data);
				xchg.getIn().setBody("INSERTED WITHOUT FEEDBACK HISTORY : " + xchg.getIn().getBody());
				break;
			}
		}

		xchg.getIn().setBody(responseMessage);
	}

	@Override
	public void returnRecomFeedbackListByCust(Exchange xchg) {
		String parentCustNum = String.valueOf(xchg.getIn().getHeader("parentCustNum").toString());
		String productLines = String.valueOf(xchg.getIn().getHeader("productLines").toString());
		String clubId = String.valueOf(xchg.getIn().getHeader("clubId").toString());

		String columns = "DISTINCT " + F_FEEDBACK_ID + "," + F_FEEDBACK_DTTM + "," + F_FEEDBACK_SYSTEM + ","
				+ F_RECOMMENDATION_SOURCE_SYSTEM + "," + F_RECOMMENDED_OFFER + "," + F_FEEDBACK_TYPE + ","
				+ F_FEEDBACK_REASON + "," + F_PRODUCT_LINES + "," + F_CLUB_ID + "," + F_PARENT_CUST_NUM + ","
				+ F_LINE_LEVEL_KEY + "," + F_LINE_LEVEL_VALUE + "," + F_CUSTOMER_NUMBER + "," + F_STAFF_ID + ","
				+ F_STAFF_NAME + "," + F_TEAM_ID + "," + F_TEAM_NAME + "," + F_CHANNEL_CODE + "," + F_CHANNEL_NAME + ","
				+ F_ENABLED_FLAG;

		String criteria = F_PRODUCT_LINES + " = " + "'" + productLines + "'" + " and " + "( " + F_CLUB_ID + " = " + "'"
				+ clubId + "'" + " or " + F_PARENT_CUST_NUM + " = " + "'" + parentCustNum + "'" + " )" + " and "
				+ F_ENABLED_FLAG + " = " + "'" + ENABLE_FLAG + "' order by " + F_FEEDBACK_DTTM + " DESC";

		String query = selectStatement(columns, T_RECOM_FB, criteria);

		System.out.println("query : " + query);
		xchg.getIn().setBody(query);
	}

	private List<RecomFeedbackHistory> getRecomFeedbackList(Exchange xchg) {
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn().getBody();
		List<RecomFeedbackHistory> recomFeedbacks = new ArrayList<RecomFeedbackHistory>();
		for (Map<String, String> data : dataList) {

			RecomFeedbackHistory recomFeedback = new RecomFeedbackHistory();

			recomFeedback.setFeedbackDttm(DataTypeUtil.dateAsString(data.get(F_FEEDBACK_DTTM), DATE_FORMAT));
			recomFeedback.setFeedbackSystem(data.get(F_FEEDBACK_SYSTEM));
			recomFeedback.setRecommendationSourceSystem(data.get(F_RECOMMENDATION_SOURCE_SYSTEM));
			recomFeedback.setRecommendedOffer(data.get(F_RECOMMENDED_OFFER));
			recomFeedback.setFeedbackType(data.get(F_FEEDBACK_TYPE));
			recomFeedback.setFeedbackReason(data.get(F_FEEDBACK_REASON));
			recomFeedback.setProductLines(data.get(F_PRODUCT_LINES));
			recomFeedback.setClubId(data.get(F_CLUB_ID));
			recomFeedback.setParentCustNum(data.get(F_PARENT_CUST_NUM));
			recomFeedback.setLineLevelKey(data.get(F_LINE_LEVEL_KEY));
			recomFeedback.setLineLevelValue(data.get(F_LINE_LEVEL_VALUE));
			recomFeedback.setCustomerNumber(data.get(F_CUSTOMER_NUMBER));
			recomFeedback.setStaffId(data.get(F_STAFF_ID));
			recomFeedback.setStaffName(data.get(F_STAFF_NAME));
			recomFeedback.setTeamId(data.get(F_TEAM_ID));
			recomFeedback.setTeamName(data.get(F_TEAM_NAME));
			recomFeedback.setChannelCode(data.get(F_CHANNEL_CODE));
			recomFeedback.setChannelName(data.get(F_CHANNEL_NAME));
			recomFeedback.setEnabledFlag(data.get(F_ENABLED_FLAG));

			recomFeedbacks.add(recomFeedback);
		}

		return recomFeedbacks;
	}

	@Override
	public boolean isRequestValid(Exchange xchg) {

		RecomFeedbackPost recomFeedbackPost = xchg.getIn().getBody(RecomFeedbackPost.class);
		RecomFeedback recomFeedback = new RecomFeedback(recomFeedbackPost);

		/** Validate mandatory values */
		boolean isMandatoryValid = isMandatoryValid(recomFeedback);
		if (!isMandatoryValid) {
			xchg.getIn().setHeader("error-code", ErrorResponseUtil.STATUS_CODE_MANDATORY);
		}

		/** club_id is not null if product_lines is "CLUB" */
		boolean isClubIdValid = validateClubId(recomFeedback);
		if (!isClubIdValid) {
			xchg.getIn().setHeader("error-code", ErrorResponseUtil.STATUS_CODE_CLUB_ID);
		}

		/** Validate feedback_reason is not null if feedback_type is "REJECT" */
		boolean isFeedbackReasonValid = validateFeedbackReason(recomFeedback);
		if (!isFeedbackReasonValid) {
			xchg.getIn().setHeader("error-code", ErrorResponseUtil.STATUS_CODE_FEEDBACK_REASON);
		}

		/** Validate line_level_key is not null if product_lines <> “CLUB” */
		boolean isLineLevelKeyValid = validateLineLevelKey(recomFeedback);
		if (!isLineLevelKeyValid) {
			xchg.getIn().setHeader("error-code", ErrorResponseUtil.STATUS_CODE_LINE_LEVEL_KEY);
		}

		/** Validate line_level_value is not null if product_lines <> “CLUB” */
		boolean isLineLevelValueValid = validateLineLevelValue(recomFeedback);
		if (!isLineLevelValueValid) {
			xchg.getIn().setHeader("error-code", ErrorResponseUtil.STATUS_CODE_LINE_LEVEL_VALUE);
		}

		/** Validate parent_cust_num is not null if product_lines <> “CLUB” */
		boolean isParentCustNumValid = validateParentCustNum(recomFeedback);
		if (!isParentCustNumValid) {
			xchg.getIn().setHeader("error-code", ErrorResponseUtil.STATUS_CODE_PARENT_CUST_NUM);
		}

		if (isMandatoryValid && isFeedbackReasonValid && isLineLevelKeyValid && isLineLevelValueValid
				&& isParentCustNumValid && isClubIdValid) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void printErrorResponseMessage(Exchange xchg) {
		ResponseMessage responseMessage = new ResponseMessage();
		RecomFeedbackPost recomFeedbackPost = xchg.getIn().getBody(RecomFeedbackPost.class);
		RecomFeedback recomFeedback = new RecomFeedback(recomFeedbackPost);

		int errorCode = (int) xchg.getIn().getHeader("error-code");
		responseMessage.setStatus(errorCode);
		responseMessage.setSuccess(false);

		if (errorCode == ErrorResponseUtil.STATUS_CODE_MANDATORY) {
			responseMessage.setMessage(ErrorResponseUtil.responseCodes.get(errorCode)
					+ returnMessageForMandatoryValidation(recomFeedback));
		} else {
			responseMessage.setMessage(ErrorResponseUtil.responseCodes.get(errorCode));
		}
		xchg.getOut().setBody(JsonUtils.convertToJson(responseMessage, "Error"));
	}

}
