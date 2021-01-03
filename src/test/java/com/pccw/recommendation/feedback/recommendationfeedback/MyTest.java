package com.pccw.recommendation.feedback.recommendationfeedback;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pccw.recommendation.feedback.model.RecomFeedback;

public class MyTest {

	@Test
	public void recomFeedback() {
		RecomFeedback recomFeedback = new RecomFeedback();
		recomFeedback.setChannelCode("test");
		assertEquals("test", recomFeedback.getChannelCode(), recomFeedback.getChannelCode());
	}

}
