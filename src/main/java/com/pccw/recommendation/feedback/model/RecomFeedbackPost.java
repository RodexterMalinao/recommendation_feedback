package com.pccw.recommendation.feedback.model;

public class RecomFeedbackPost {

	private String feedbackSystem;
	private String recommendationSourceSystem;
	private String recommendedOffer;
	private String feedbackType;
	private String feedbackReason;
	private String customerType;
	private String clubId;
	private String mobileNumber;
	private String fsa;
	private String serviceNumber;
	private String customerNumber;
	private String staffId;
	private String staffName;
	private String teamId;
	private String teamName;
	private String channelCode;
	private String channelName;

	public String getFeedbackSystem() {
		return feedbackSystem;
	}

	public void setFeedbackSystem(String feedbackSystem) {
		this.feedbackSystem = feedbackSystem;
	}

	public String getRecommendationSourceSystem() {
		return recommendationSourceSystem;
	}

	public void setRecommendationSourceSystem(String recommmendationSourceSystem) {
		this.recommendationSourceSystem = recommmendationSourceSystem;
	}

	public String getRecommendedOffer() {
		return recommendedOffer;
	}

	public void setRecommendedOffer(String recommendedOffer) {
		this.recommendedOffer = recommendedOffer;
	}

	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

	public String getFeedbackReason() {
		return feedbackReason;
	}

	public void setFeedbackReason(String feedbackReason) {
		this.feedbackReason = feedbackReason;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFsa() {
		return fsa;
	}

	public void setFsa(String fsa) {
		this.fsa = fsa;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public String toString() {
		return "RecomFeedback [feedbackSystem=" + feedbackSystem + ", recommendationSourceSystem="
				+ recommendationSourceSystem + ", recommendedOffer=" + recommendedOffer + ", feedbackType="
				+ feedbackType + ", feedbackReason=" + feedbackReason + ", customerType=" + customerType + ", clubId="
				+ clubId + ", mobileNumber=" + mobileNumber + ", fsa=" + fsa + ", serviceNumber=" + serviceNumber
				+ ", customerNumber=" + customerNumber + ", staffId=" + staffId + ", staffName=" + staffName
				+ ", teamId=" + teamId + ", teamName=" + teamName + ", channelCode=" + channelCode + ", channelName="
				+ channelName + "]";
	}

}