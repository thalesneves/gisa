package com.puc.gisa.infocadastral.api;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class GenericAPI {
	
	public static String executeAPI(final String endPoint, HttpMethod httpMethod) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate.exchange(endPoint, httpMethod, entity, String.class).getBody();
	}

}
