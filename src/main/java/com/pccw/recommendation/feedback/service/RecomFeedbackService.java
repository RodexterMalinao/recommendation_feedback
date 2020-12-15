package com.pccw.recommendation.feedback.service;

import java.util.List;

import org.apache.camel.Exchange;

import com.pccw.recommendation.feedback.model.RecomFeedback;

/**
 * Service interface for name service.
 * 
 */
public interface RecomFeedbackService {

	/**
	 * Generate Greetings
	 *
	 * @return a string greetings
	 */
	public List<RecomFeedback> getRecomFeedback(Exchange xchg);

	public void insertRecomFeedback(Exchange xchg);

}