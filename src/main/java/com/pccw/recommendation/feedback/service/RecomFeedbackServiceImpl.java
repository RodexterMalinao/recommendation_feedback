package com.pccw.recommendation.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

import com.pccw.recommendation.feedback.model.RecomFeedback;
import com.pccw.recommendation.feedback.util.DataTypeUtil;

@Service("recomFeedbackService")
public class RecomFeedbackServiceImpl implements RecomFeedbackService {

	@Override
	public List<RecomFeedback> getRecomFeedback(Exchange xchg) {
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn().getBody();
		List<RecomFeedback> recomFeedbacks = new ArrayList<RecomFeedback>();

		System.out.println(dataList);
		for (Map<String, String> data : dataList) {

			RecomFeedback recomFeedback = new RecomFeedback();

			recomFeedback.setFeedbackId(DataTypeUtil.integerAsString(data.get("feedback_id")));
			recomFeedback.setFeedbackDttm(DataTypeUtil.dateAsString(data.get("feedback_dttm"),"MM-dd-yyyy"));
			recomFeedback.setFeedbackSystem(data.get("feedback_system"));
			recomFeedback.setRecommmendationSourceSystem(data.get("recommmendation_source_system"));
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
		String query = "INSERT INTO recommendation_feedback(feedback_id," + "feedback_dttm," + "feedback_system,"
				+ "recommmendation_source_system," + "recommended_offer," + "feedback_type," + "feedback_reason,"
				+ "customer_type," + "club_id," + "mobile_number," + "fsa," + "service_number," + "customer_number,"
				+ "staff_id," + "staff_name," + "team_id," + "team_name," + "channel_code," + "channel_name," + "enabled_flag)"
				+ "values('" 
				+ recomFeedback.getFeedbackId()+ "','" 
				+ recomFeedback.getFeedbackDttm() + "','"
				+ recomFeedback.getFeedbackSystem()  + "','"
				+ recomFeedback.getRecommmendationSourceSystem()  + "','"
				+ recomFeedback.getRecommendedOffer()  + "','"
				+ recomFeedback.getFeedbackType()  + "','"
				+ recomFeedback.getFeedbackReason()  + "','"
				+ recomFeedback.getCustomerType()  + "','"
				+ recomFeedback.getClubId()  + "','"
				+ recomFeedback.getMobileNumber()  + "','"
				+ recomFeedback.getFsa()  + "','"
				+ recomFeedback.getServiceNumber()  + "','"
				+ recomFeedback.getCustomerNumber()  + "','"
				+ recomFeedback.getStaffId()  + "','"
				+ recomFeedback.getStaffName()  + "','"
				+ recomFeedback.getTeamId()  + "','"
				+ recomFeedback.getTeamName()  + "','"
				+ recomFeedback.getChannelCode()  + "','"
				+ recomFeedback.getChannelName()  + "','"
				+ recomFeedback.getEnabledFlag()
				+ "')";
		System.out.println("query roy : "+query);
		xchg.getIn().setBody(query);
	}
}

//public void insertRecomFeedback(Exchange xchg) {
//	RecomFeedback recomFeedback = xchg.getIn().getBody(RecomFeedback.class);
//	String query = "INSERT INTO recomFeedback(empId,empName)values('" + recomFeedback.get() + "','"
//			+ recomFeedback.getEmpName() + "')";
//	xchg.getIn().setBody(query);
//}