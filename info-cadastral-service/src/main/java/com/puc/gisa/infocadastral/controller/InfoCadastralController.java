package com.puc.gisa.infocadastral.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.gisa.infocadastral.dto.StakeHolderDTO;
import com.puc.gisa.infocadastral.service.InfoCadastralService;

@RestController
@RequestMapping("/infocadastral")
public class InfoCadastralController {
	
	@Autowired
	private InfoCadastralService infoService;
	
	@GetMapping(path = "/users")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public ResponseEntity<List<StakeHolderDTO>> findAll() throws IOException {
		return infoService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public ResponseEntity<StakeHolderDTO> findById(@PathVariable final Long id) {
		return infoService.findById(id);
	}
	
}
