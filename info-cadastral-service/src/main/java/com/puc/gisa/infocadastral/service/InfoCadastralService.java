package com.puc.gisa.infocadastral.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puc.gisa.infocadastral.api.SmockerAPI;
import com.puc.gisa.infocadastral.constants.URLConstants;
import com.puc.gisa.infocadastral.dto.UserDTO;

@Service
public class InfoCadastralService {
	
	public ResponseEntity<List<UserDTO>> findAll() throws IOException {
		String resultAPI = SmockerAPI.find(URLConstants.URL_GET_USERS);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<UserDTO> stakeHolders = Arrays.asList(mapper.readValue(resultAPI, UserDTO[].class));
		
		if (stakeHolders != null) {
			return ResponseEntity.ok(stakeHolders);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<List<UserDTO>> findPrestadores() throws IOException {
		String resultAPI = SmockerAPI.find(URLConstants.URL_GET_PRESTADOR);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<UserDTO> stakeHolders = Arrays.asList(mapper.readValue(resultAPI, UserDTO[].class));
		
		if (stakeHolders != null) {
			return ResponseEntity.ok(stakeHolders);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<List<UserDTO>> findAssociados() throws IOException {
		String resultAPI = SmockerAPI.find(URLConstants.URL_GET_ASSOCIADO);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<UserDTO> stakeHolders = Arrays.asList(mapper.readValue(resultAPI, UserDTO[].class));
		
		if (stakeHolders != null) {
			return ResponseEntity.ok(stakeHolders);
		}
		
		return ResponseEntity.notFound().build();
	}

}
