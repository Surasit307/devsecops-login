package com.ttb.fleet.login.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApiUtils {

	private final static Logger logger = LoggerFactory.getLogger(ApiUtils.class);

	public static <T, G> G callPostApi(String url, T request, Class<G> responseClass) {
		HttpEntity<T> payload = new HttpEntity<>(request);
		RestTemplateBuilder builder = new RestTemplateBuilder();
		RestTemplate restTemplate = builder.build();
		ResponseEntity<G> response = restTemplate.postForEntity(url, payload, responseClass);
		if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
			logger.debug("call api " + url + " successful");
			return response.getBody();
		} else {
			logger.debug("call api " + url + " failed");
			return null;
		}
	}
}
