package com.pccw.recommendation.feedback.model;

public class RecomFeedback {

	private int feedbackId;
	private String feedbackDttm;
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
	private String enabledFlag;

	public RecomFeedback(RecomFeedbackPost recomFeedbackPost) {
		this.setFeedbackSystem(recomFeedbackPost.getFeedbackSystem());
		this.setRecommendationSourceSystem(recomFeedbackPost.getRecommendationSourceSystem());
		this.setRecommendedOffer(recomFeedbackPost.getRecommendedOffer());
		this.setFeedbackType(recomFeedbackPost.getFeedbackType());
		this.setFeedbackReason(recomFeedbackPost.getFeedbackReason());
		this.setCustomerType(recomFeedbackPost.getCustomerType());
		this.setClubId(recomFeedbackPost.getClubId());
		this.setMobileNumber(recomFeedbackPost.getMobileNumber());
		this.setFsa(recomFeedbackPost.getFsa());
		this.setServiceNumber(recomFeedbackPost.getServiceNumber());
		this.setCustomerNumber(recomFeedbackPost.getCustomerNumber());
		this.setStaffId(recomFeedbackPost.getStaffId());
		this.setStaffName(recomFeedbackPost.getStaffName());
		this.setTeamId(recomFeedbackPost.getTeamId());
		this.setTeamName(recomFeedbackPost.getTeamName());
		this.setChannelCode(recomFeedbackPost.getChannelCode());
		this.setChannelName(recomFeedbackPost.getChannelName());
	}

	public RecomFeedback(int feedbackId, String feedbackDttm, String feedbackSystem, String recommendationSourceSystem,
			String recommendedOffer, String feedbackType, String feedbackReason, String customerType, String clubId,
			String mobileNumber, String fsa, String serviceNumber, String customerNumber, String staffId,
			String staffName, String teamId, String teamName, String channelCode, String channelName,
			String enabledFlag) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackDttm = feedbackDttm;
		this.feedbackSystem = feedbackSystem;
		this.recommendationSourceSystem = recommendationSourceSystem;
		this.recommendedOffer = recommendedOffer;
		this.feedbackType = feedbackType;
		this.feedbackReason = feedbackReason;
		this.customerType = customerType;
		this.clubId = clubId;
		this.mobileNumber = mobileNumber;
		this.fsa = fsa;
		this.serviceNumber = serviceNumber;
		this.customerNumber = customerNumber;
		this.staffId = staffId;
		this.staffName = staffName;
		this.teamId = teamId;
		this.teamName = teamName;
		this.channelCode = channelCode;
		this.channelName = channelName;
		this.enabledFlag = enabledFlag;
	}

	public RecomFeedback() {
		// TODO Auto-generated constructor stub
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackDttm() {
		return feedbackDttm;
	}

	public void setFeedbackDttm(String feedbackDttm) {
		this.feedbackDttm = feedbackDttm;
	}

	public String getFeedbackSystem() {
		return feedbackSystem;
	}

	public void setFeedbackSystem(String feedbackSystem) {
		this.feedbackSystem = feedbackSystem;
	}

	public String getRecommendationSourceSystem() {
		return recommendationSourceSystem;
	}

	public void setRecommendationSourceSystem(String recommendationSourceSystem) {
		this.recommendationSourceSystem = recommendationSourceSystem;
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

	public String getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

	@Override
	public String toString() {
		return "RecomFeedback [feedbackId=" + feedbackId + ", feedbackDttm=" + feedbackDttm + ", feedbackSystem="
				+ feedbackSystem + ", recommmendationSourceSystem=" + recommendationSourceSystem + ", recommendedOffer="
				+ recommendedOffer + ", feedbackType=" + feedbackType + ", feedbackReason=" + feedbackReason
				+ ", customerType=" + customerType + ", clubId=" + clubId + ", mobileNumber=" + mobileNumber + ", fsa="
				+ fsa + ", serviceNumber=" + serviceNumber + ", customerNumber=" + customerNumber + ", staffId="
				+ staffId + ", staffName=" + staffName + ", teamId=" + teamId + ", teamName=" + teamName
				+ ", channelCode=" + channelCode + ", channelName=" + channelName + ", enabledFlag=" + enabledFlag
				+ "]";
	}

}