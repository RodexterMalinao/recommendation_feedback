package com.pccw.recommendation.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

import com.pccw.recommendation.feedback.model.RecomFeedback;
import com.pccw.recommendation.feedback.response.Data;
import com.pccw.recommendation.feedback.response.RecomFeedbackHistory;
import com.pccw.recommendation.feedback.response.ResponseMessage;
import com.pccw.recommendation.feedback.util.DataTypeUtil;

@Service("recomFeedbackService")
public class RecomFeedbackServiceImpl implements RecomFeedbackService {

	@Override
	public List<RecomFeedback> retrieveRecomFeedback(Exchange xchg) {
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn().getBody();
		List<RecomFeedback> recomFeedbacks = new ArrayList<RecomFeedback>();

		System.out.println(dataList);
		for (Map<String, String> data : dataList) {

			RecomFeedback recomFeedback = new RecomFeedback();

			recomFeedback.setFeedbackId(DataTypeUtil.stringAsInteger(data.get("feedback_id")));
			recomFeedback.setFeedbackDttm(DataTypeUtil.dateAsString(data.get("feedback_dttm"), "MM-dd-yyyy"));
			recomFeedback.setFeedbackSystem(data.get("feedback_system"));
			recomFeedback.setRecommendationSourceSystem(data.get("recommmendation_source_system"));
			recomFeedback.setRecommendedOffer(data.get("recommended_offer"));
			recomFeedback.setFeedbackType(data.get("feedback_type"));
			recomFeedback.setFeedbackReason(data.get("feedback_reason"));
			recomFeedback.setCustomerType(data.get("customer_type"));
			recomFeedback.setClubId(data.get("club_id"));
			recomFeedback.setMobileNumber(data.get("mobile_number"));
			recomFeedback.setFsa(data.get("fsa"));
			recomFeedback.setServiceNumber(data.get("service_number"));
			recomFeedback.setCustomerNumber(data.get("customer_number"));
			recomFeedback.setStaffId(data.get("staff_id"));
			recomFeedback.setStaffName(data.get("staff_name"));
			recomFeedback.setTeamId(data.get("team_id"));
			recomFeedback.setTeamName(data.get("team_name"));
			recomFeedback.setChannelCode(data.get("channel_code"));
			recomFeedback.setChannelName(data.get("channel_name"));
			recomFeedback.setEnabledFlag(data.get("enabled_flag"));

			recomFeedbacks.add(recomFeedback);
		}

		return recomFeedbacks;
	}

	@Override
	public void insertRecomFeedback(Exchange xchg) {
		RecomFeedback recomFeedback = xchg.getIn().getBody(RecomFeedback.class);

		System.out.println("recomFeedback.getFeedbackDttm() : " + recomFeedback.getFeedbackDttm());
		String query = "INSERT INTO recommendation_feedback(feedback_dttm," + "feedback_system,"
				+ "recommendation_source_system," + "recommended_offer," + "feedback_type," + "feedback_reason,"
				+ "customer_type," + "club_id," + "mobile_number," + "fsa," + "service_number," + "customer_number,"
				+ "staff_id," + "staff_name," + "team_id," + "team_name," + "channel_code," + "channel_name,"
				+ "enabled_flag)" + "values('" + recomFeedback.getFeedbackDttm() + "','"
				+ recomFeedback.getFeedbackSystem() + "','" + recomFeedback.getRecommendationSourceSystem() + "','"
				+ recomFeedback.getRecommendedOffer() + "','" + recomFeedback.getFeedbackType() + "','"
				+ recomFeedback.getFeedbackReason() + "','" + recomFeedback.getCustomerType() + "','"
				+ recomFeedback.getClubId() + "','" + recomFeedback.getMobileNumber() + "','" + recomFeedback.getFsa()
				+ "','" + recomFeedback.getServiceNumber() + "','" + recomFeedback.getCustomerNumber() + "','"
				+ recomFeedback.getStaffId() + "','" + recomFeedback.getStaffName() + "','" + recomFeedback.getTeamId()
				+ "','" + recomFeedback.getTeamName() + "','" + recomFeedback.getChannelCode() + "','"
				+ recomFeedback.getChannelName() + "','" + recomFeedback.getEnabledFlag() + "')";
//		System.out.println("query roy : " + query);
		xchg.getIn().setBody(query);
		System.out.println("getIn : " + xchg.getIn().getBody());
//		xchg.getOut().setBody("SELECT 'message' AS '" + recomFeedback.getFeedbackDttm() + "'");
	}

	@Override
	public void returnId(Exchange xchg) {
		RecomFeedback recomFeedback = xchg.getIn().getBody(RecomFeedback.class);
		System.out.println("recomFeedback : " + xchg.getIn().getBody());
		String query = "SELECT feedback_id FROM recommendation_feedback WHERE club_id = " + "'"
				+ recomFeedback.getClubId() + "'" + " and mobile_number = " + "'" + recomFeedback.getMobileNumber()
				+ "'" + " and FSA =" + "'" + recomFeedback.getFsa() + "'" + " and service_number =" + "'"
				+ recomFeedback.getServiceNumber() + "'" + " and customer_number =" + "'"
				+ recomFeedback.getCustomerNumber() + "'" + " and feedback_system =" + "'"
				+ recomFeedback.getFeedbackSystem() + "'" + " and recommendation_source_system =" + "'"
				+ recomFeedback.getRecommendationSourceSystem() + "'" + " and recommended_offer =" + "'"
				+ recomFeedback.getRecommendedOffer() + "'" + " and feedback_type =" + "'"
				+ recomFeedback.getFeedbackType() + "'" + " and feedback_reason =" + "'"
				+ recomFeedback.getFeedbackReason() + "'" + " and customer_type =" + "'"
				+ recomFeedback.getCustomerType() + "'" + " and staff_id =" + "'" + recomFeedback.getStaffId() + "'"
				+ " and staff_name =" + "'" + recomFeedback.getStaffName() + "'" + " and team_id =" + "'"
				+ recomFeedback.getTeamId() + "'" + " and team_name =" + "'" + recomFeedback.getTeamName() + "'"
				+ " and channel_code =" + "'" + recomFeedback.getChannelCode() + "'" + " and channel_name =" + "'"
				+ recomFeedback.getChannelName() + "'" + " and enabled_flag =" + "'" + recomFeedback.getEnabledFlag()
				+ "' ORDER BY feedback_id DESC LIMIT 1";
		xchg.getIn().setBody(query);
		System.out.println("getIn : " + xchg.getIn().getBody());
	}

	@Override
	public void printResponseMessage(Exchange xchg) {

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
				responseMessage.setMessage("Insert record with feedback history");
				data.setFeedbackId(feedbackId);
				data.setHistory(recomFeedbacks);
				responseMessage.setData(data);
				System.out.println("recomFeedbacks : " + recomFeedbacks);
				xchg.getIn().setBody("INSERTED WITH FEEDBACK HISTORY : " + xchg.getIn().getBody());
				break;
			default:
				responseMessage.setStatus("200");
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
		String query = "SELECT feedback_dttm, feedback_system, recommendation_source_system, recommended_offer, feedback_type, feedback_reason, customer_type, club_id,mobile_number, fsa, service_number, customer_number, staff_id, staff_name, team_id, team_name, channel_code, channel_name, enabled_flag FROM recommendation_feedback WHERE club_id = "
				+ "'" + clubId + "'" + " and mobile_number = " + "'" + mobileNumber + "'" + " and FSA =" + "'" + fsa
				+ "'" + " and service_number =" + "'" + serviceNumber + "'" + " and customer_number =" + "'"
				+ customerNumber + "'" + " ORDER BY feedback_id ASC";
		xchg.getIn().setBody(query);
		System.out.println("query : " + query);
	}

	public List<RecomFeedbackHistory> getRecomFeedbackList(Exchange xchg) {
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn().getBody();
		List<RecomFeedbackHistory> recomFeedbacks = new ArrayList<RecomFeedbackHistory>();
		for (Map<String, String> data : dataList) {

			RecomFeedbackHistory recomFeedback = new RecomFeedbackHistory();

			recomFeedback.setFeedbackDttm(DataTypeUtil.dateAsString(data.get("feedback_dttm"), "MM-dd-yyyy"));
			recomFeedback.setFeedbackSystem(data.get("feedback_system"));
			recomFeedback.setRecommendationSourceSystem(data.get("recommmendation_source_system"));
			recomFeedback.setRecommendedOffer(data.get("recommended_offer"));
			recomFeedback.setFeedbackType(data.get("feedback_type"));
			recomFeedback.setFeedbackReason(data.get("feedback_reason"));
			recomFeedback.setCustomerType(data.get("customer_type"));
			recomFeedback.setClubId(data.get("club_id"));
			recomFeedback.setMobileNumber(data.get("mobile_number"));
			recomFeedback.setFsa(data.get("fsa"));
			recomFeedback.setServiceNumber(data.get("service_number"));
			recomFeedback.setCustomerNumber(data.get("customer_number"));
			recomFeedback.setStaffId(data.get("staff_id"));
			recomFeedback.setStaffName(data.get("staff_name"));
			recomFeedback.setTeamId(data.get("team_id"));
			recomFeedback.setTeamName(data.get("team_name"));
			recomFeedback.setChannelCode(data.get("channel_code"));
			recomFeedback.setChannelName(data.get("channel_name"));
			recomFeedback.setEnabledFlag(data.get("enabled_flag"));

			recomFeedbacks.add(recomFeedback);
		}

		return recomFeedbacks;
	}
}

//public void insertRecomFeedback(Exchange xchg) {
//	RecomFeedback recomFeedback = xchg.getIn().getBody(RecomFeedback.class);
//	String query = "INSERT INTO recomFeedback(empId,empName)values('" + recomFeedback.get() + "','"
//			+ recomFeedback.getEmpName() + "')";
//	xchg.getIn().setBody(query);
//}