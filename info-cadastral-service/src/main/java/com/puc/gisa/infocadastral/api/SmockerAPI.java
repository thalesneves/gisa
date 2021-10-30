package com.puc.gisa.infocadastral.api;

import org.springframework.http.HttpMethod;

public class SmockerAPI {
	
	public static String find(final String endPoint) {
		return GenericAPI.executeAPI(endPoint, HttpMethod.GET);
	}
	
}
