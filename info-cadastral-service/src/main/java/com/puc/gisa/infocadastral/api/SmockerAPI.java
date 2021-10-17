package com.puc.gisa.infocadastral.api;

import org.springframework.http.HttpMethod;

import com.puc.gisa.infocadastral.constants.URLConstants;

public class SmockerAPI {
	
	public static String findAll() {
		String endPoint = URLConstants.URL_GET_USERS;
		
		return GenericAPI.executeAPI(endPoint, HttpMethod.GET);
	}
	
	public static String findById(final Long id) {
		String endPoint = URLConstants.URL_GET_USERS + "/" + id;
		
		return GenericAPI.executeAPI(endPoint, HttpMethod.GET);
	}

}
