package com.puc.gisa.infocadastral.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.puc.gisa.infocadastral.api.SmockerAPI;
import com.puc.gisa.infocadastral.dto.StakeHolderDTO;

@Service
public class InfoCadastralService {
	
	public ResponseEntity<List<StakeHolderDTO>> findAll() throws IOException {
		String resultAPI = SmockerAPI.findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<StakeHolderDTO> stakeHolders = Arrays.asList(mapper.readValue(resultAPI, StakeHolderDTO[].class));
		
		if (stakeHolders != null) {
			return ResponseEntity.ok(stakeHolders);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<StakeHolderDTO> findById(final Long id) {
		String resultAPI = SmockerAPI.findById(id);
		
		StakeHolderDTO stakeHolder = new Gson().fromJson(resultAPI, StakeHolderDTO.class);
		
		if (stakeHolder != null) {
			return ResponseEntity.ok(stakeHolder);
		}
		
		return ResponseEntity.notFound().build();
	}

}
