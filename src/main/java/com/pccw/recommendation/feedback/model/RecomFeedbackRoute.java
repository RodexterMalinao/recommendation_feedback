package com.pccw.recommendation.feedback.model;

import java.util.List;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.pccw.recommendation.feedback.service.RecomFeedbackService;
import com.pccw.recommendation.feedback.service.RecomFeedbackServiceImpl;

@Component
public class RecomFeedbackRoute extends RouteBuilder {

	@Autowired
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	RecomFeedbackService recomFeedbackService = new RecomFeedbackServiceImpl();

	@Override
	public void configure() {
		restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

		rest("/retrieve").get().outType(RecomFeedback.class).to("direct:select");

		rest("/insert").post().produces(MediaType.APPLICATION_JSON_VALUE).type(RecomFeedback.class).route()
				.routeId("postRecomFeedbackRoute").log("--- binded ${body} ---").to("direct:insert")
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201)).setBody(constant(null));

		from("direct:select").setBody(constant("select * from recommendation_feedback")).to("jdbc:dataSource")
				.process(new Processor() {
					public void process(Exchange xchg) throws Exception {
						List<RecomFeedback> employees = recomFeedbackService.getRecomFeedback(xchg);
						xchg.getIn().setBody(employees);
					}
				});

		from("direct:insert").process(new Processor() {
			public void process(Exchange xchg) throws Exception {
				recomFeedbackService.insertRecomFeedback(xchg);
			}
		}).to("jdbc:dataSource");
	}
}

//from("direct:talk").process(exchange -> {
//RecomFeedback p = new RecomFeedback();
//p.setFirstname("Bennet");
//p.setLastname("Schulz");
//exchange.getIn().setBody(p);
//});
