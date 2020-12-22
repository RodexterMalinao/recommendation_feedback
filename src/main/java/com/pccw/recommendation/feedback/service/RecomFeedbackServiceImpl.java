package com.pccw.recommendation.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.json.simple.JsonObject;
import org.springframework.stereotype.Service;

import com.pccw.recommendation.feedback.model.RecomFeedback;
import com.pccw.recommendation.feedback.model.RecomFeedbackPost;
import com.pccw.recommendation.feedback.response.Data;
import com.pccw.recommendation.feedback.response.RecomFeedbackHistory;
import com.pccw.recommendation.feedback.response.ResponseMessage;
import com.pccw.recommendation.feedback.util.DataTypeUtil;
import com.pccw.recommendation.feedback.util.ErrorResponseUtil;
import com.pccw.recommendation.feedback.util.RecomFeedbackUtil;

import net.javacrumbs.jsonunit.core.internal.JsonUtils;

@Service("recomFeedbackService")
public class RecomFeedbackServiceImpl extends RecomFeedbackUtil implements RecomFeedbackService {

	@Override
	public List<RecomFeedback> retrieveRecomFeedback(Exchange xchg) {
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn().getBody();
		List<RecomFeedback> recomFeedbacks = new ArrayList<RecomFeedback>();

		System.out.println(dataList);
		for (Map<String, String> data : dataList) {

			RecomFeedback recomFeedback = new RecomFeedback();

			recomFeedback.setFeedbackId(DataTypeUtil.stringAsInteger(data.get(F_FEEDBACK_ID)));
			recomFeedback.setFeedbackDttm(DataTypeUtil.dateAsString(data.get(F_FEEDBACK_DTTM), "yyyy-mm-dd hh:mm:ss"));
			recomFeedback.setFeedbackSystem(data.get(F_FEEDBACK_SYSTEM));
			recomFeedback.setRecommendationSourceSystem(data.get(F_RECOMMENDATION_SOURCE_SYSTEM));
			recomFeedback.setRecommendedOffer(data.get(F_RECOMMENDED_OFFER));
			recomFeedback.setFeedbackType(data.get(F_FEEDBACK_TYPE));
			recomFeedback.setFeedbackReason(data.get(F_FEEDBACK_REASON));
			recomFeedback.setCustomerType(data.get(F_CUSTOMER_TYPE));
			recomFeedback.setClubId(data.get(F_CLUB_ID));
			recomFeedback.setMobileNumber(data.get(F_MOBILE_NUMBER));
			recomFeedback.setFsa(data.get(F_FSA));
			recomFeedback.setServiceNumber(data.get(F_SERVICE_NUMBER));
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
	public void insertRecomFeedback(Exchange xchg) {

		RecomFeedbackPost recomFeedbackPost = xchg.getIn().getBody(RecomFeedbackPost.class);
		RecomFeedback recomFeedback = new RecomFeedback(recomFeedbackPost);

		String query = "INSERT INTO " + T_RECOM_FB + "(" + F_FEEDBACK_SYSTEM + "," + F_RECOMMENDATION_SOURCE_SYSTEM
				+ "," + F_RECOMMENDED_OFFER + "," + F_FEEDBACK_TYPE + "," + F_FEEDBACK_REASON + "," + F_CUSTOMER_TYPE
				+ "," + F_CLUB_ID + "," + F_MOBILE_NUMBER + "," + F_FSA + "," + F_SERVICE_NUMBER + ","
				+ F_CUSTOMER_NUMBER + "," + F_STAFF_ID + "," + F_STAFF_NAME + "," + F_TEAM_ID + "," + F_TEAM_NAME + ","
				+ F_CHANNEL_CODE + "," + F_CHANNEL_NAME + ")" + "values('" + recomFeedback.getFeedbackSystem() + "','"
				+ recomFeedback.getRecommendationSourceSystem() + "','" + recomFeedback.getRecommendedOffer() + "','"
				+ recomFeedback.getFeedbackType() + "','" + recomFeedback.getFeedbackReason() + "','"
				+ recomFeedback.getCustomerType() + "','" + recomFeedback.getClubId() + "','"
				+ recomFeedback.getMobileNumber() + "','" + recomFeedback.getFsa() + "','"
				+ recomFeedback.getServiceNumber() + "','" + recomFeedback.getCustomerNumber() + "','"
				+ recomFeedback.getStaffId() + "','" + recomFeedback.getStaffName() + "','" + recomFeedback.getTeamId()
				+ "','" + recomFeedback.getTeamName() + "','" + recomFeedback.getChannelCode() + "','"
				+ recomFeedback.getChannelName() + "')";
//			System.out.println("query roy : " + query);
		xchg.getIn().setBody(query);
		System.out.println("getIn : " + xchg.getIn().getBody());
//			xchg.getOut().setBody("SELECT 'message' AS '" + recomFeedback.getFeedbackDttm() + "'");

	}

	@Override
	public void returnId(Exchange xchg) {
		RecomFeedbackPost recomFeedbackPost = xchg.getIn().getBody(RecomFeedbackPost.class);
		RecomFeedback recomFeedback = new RecomFeedback(recomFeedbackPost);

		System.out.println("recomFeedback : " + xchg.getIn().getBody());
		String query = "SELECT " + F_FEEDBACK_ID + " FROM " + T_RECOM_FB + " WHERE " + F_CLUB_ID + " = " + "'"
				+ recomFeedback.getClubId() + "'" + " and " + F_MOBILE_NUMBER + " = " + "'"
				+ recomFeedback.getMobileNumber() + "'" + " and " + F_FSA + " =" + "'" + recomFeedback.getFsa() + "'"
				+ " and " + F_SERVICE_NUMBER + " =" + "'" + recomFeedback.getServiceNumber() + "'" + " and "
				+ F_CUSTOMER_NUMBER + " =" + "'" + recomFeedback.getCustomerNumber() + "'" + " and " + F_FEEDBACK_SYSTEM
				+ " =" + "'" + recomFeedback.getFeedbackSystem() + "'" + " and " + F_RECOMMENDATION_SOURCE_SYSTEM + " ="
				+ "'" + recomFeedback.getRecommendationSourceSystem() + "'" + " and " + F_RECOMMENDED_OFFER + " =" + "'"
				+ recomFeedback.getRecommendedOffer() + "'" + " and " + F_FEEDBACK_TYPE + " =" + "'"
				+ recomFeedback.getFeedbackType() + "'" + " and " + F_FEEDBACK_REASON + " =" + "'"
				+ recomFeedback.getFeedbackReason() + "'" + " and " + F_CUSTOMER_TYPE + " =" + "'"
				+ recomFeedback.getCustomerType() + "'" + " and " + F_STAFF_ID + " =" + "'" + recomFeedback.getStaffId()
				+ "'" + " and " + F_STAFF_NAME + " =" + "'" + recomFeedback.getStaffName() + "'" + " and " + F_TEAM_ID
				+ " =" + "'" + recomFeedback.getTeamId() + "'" + " and " + F_TEAM_NAME + " =" + "'"
				+ recomFeedback.getTeamName() + "'" + " and " + F_CHANNEL_CODE + " =" + "'"
				+ recomFeedback.getChannelCode() + "'" + " and " + F_CHANNEL_NAME + " =" + "'"
				+ recomFeedback.getChannelName() + "' ORDER BY " + F_FEEDBACK_ID + " DESC LIMIT 1";
		xchg.getIn().setBody(query);
		System.out.println("getIn : " + xchg.getIn().getBody());
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
				responseMessage.setStatus("200");
				responseMessage.setSuccess("true");
				responseMessage.setMessage("Insert record with feedback history");
				data.setFeedbackId(feedbackId);
				data.setHistory(recomFeedbacks);
				responseMessage.setData(data);
				System.out.println("recomFeedbacks : " + recomFeedbacks);
				xchg.getIn().setBody("INSERTED WITH FEEDBACK HISTORY : " + xchg.getIn().getBody());
			default:
				responseMessage.setStatus("200");
				responseMessage.setSuccess("true");
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
		String clubId = String.valueOf(xchg.getIn().getHeader("clubId").toString());
		String mobileNumber = String.valueOf(xchg.getIn().getHeader("mobileNumber"));
		String fsa = String.valueOf(xchg.getIn().getHeader("FSA"));
		String serviceNumber = String.valueOf(xchg.getIn().getHeader("serviceNumber"));
		String customerNumber = String.valueOf(xchg.getIn().getHeader("customerNumber"));

		System.out.println("recomFeedback : " + xchg.getIn().getBody());
		String query = "SELECT " + F_FEEDBACK_DTTM + ", " + F_FEEDBACK_SYSTEM + ", " + F_RECOMMENDATION_SOURCE_SYSTEM
				+ ", " + F_RECOMMENDED_OFFER + ", " + F_FEEDBACK_TYPE + ", " + F_FEEDBACK_REASON + ", "
				+ F_CUSTOMER_TYPE + ", " + F_CLUB_ID + "," + F_MOBILE_NUMBER + ", " + F_FSA + ", " + F_SERVICE_NUMBER
				+ ", " + F_CUSTOMER_NUMBER + ", " + F_STAFF_ID + ", " + F_STAFF_NAME + ", " + F_TEAM_ID + ", "
				+ F_TEAM_NAME + ", " + F_CHANNEL_CODE + ", " + F_CHANNEL_NAME + ", " + F_ENABLED_FLAG + " FROM "
				+ T_RECOM_FB + " WHERE " + F_CLUB_ID + " = " + "'" + clubId + "'" + " and " + F_MOBILE_NUMBER + " = "
				+ "'" + mobileNumber + "'" + " and " + F_FSA + " =" + "'" + fsa + "'" + " and " + F_SERVICE_NUMBER
				+ " =" + "'" + serviceNumber + "'" + " and " + F_CUSTOMER_NUMBER + " =" + "'" + customerNumber + "'"
				+ " ORDER BY " + F_FEEDBACK_ID + " ASC";
		xchg.getIn().setBody(query);
		System.out.println("query : " + query);
	}

	private List<RecomFeedbackHistory> getRecomFeedbackList(Exchange xchg) {
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn().getBody();
		List<RecomFeedbackHistory> recomFeedbacks = new ArrayList<RecomFeedbackHistory>();
		for (Map<String, String> data : dataList) {

			RecomFeedbackHistory recomFeedback = new RecomFeedbackHistory();

			recomFeedback.setFeedbackDttm(DataTypeUtil.dateAsString(data.get(F_FEEDBACK_DTTM), "yyyy-mm-dd hh:mm:ss"));
			recomFeedback.setFeedbackSystem(data.get(F_FEEDBACK_SYSTEM));
			recomFeedback.setRecommendationSourceSystem(data.get(F_RECOMMENDATION_SOURCE_SYSTEM));
			recomFeedback.setRecommendedOffer(data.get(F_RECOMMENDED_OFFER));
			recomFeedback.setFeedbackType(data.get(F_FEEDBACK_TYPE));
			recomFeedback.setFeedbackReason(data.get(F_FEEDBACK_REASON));
			recomFeedback.setCustomerType(data.get(F_CUSTOMER_TYPE));
			recomFeedback.setClubId(data.get(F_CLUB_ID));
			recomFeedback.setMobileNumber(data.get(F_MOBILE_NUMBER));
			recomFeedback.setFsa(data.get(F_FSA));
			recomFeedback.setServiceNumber(data.get(F_SERVICE_NUMBER));
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

		/** Validate mandatory fields */
		if (isMandatoryValid(recomFeedback)) {
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

		responseMessage.setStatus(ErrorResponseUtil.STATUS_CODE_MANDATORY);
		responseMessage.setSuccess("false");
		responseMessage.setMessage(
				ErrorResponseUtil.responseCodes.get(Integer.parseInt(ErrorResponseUtil.STATUS_CODE_MANDATORY))
						+ returnMessageForMandatoryValidation(recomFeedback));
		xchg.getOut().setBody(JsonUtils.convertToJson(responseMessage, "Error"));
	}

}

//JsonObject body = new JsonObject();
//body.put("type", "msg");
//body.put("data", "test");
//xchg.getOut().setBody(body.toJson());
