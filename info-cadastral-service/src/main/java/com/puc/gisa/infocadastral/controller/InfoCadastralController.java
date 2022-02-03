package com.puc.gisa.infocadastral.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.gisa.infocadastral.dto.UserDTO;
import com.puc.gisa.infocadastral.service.InfoCadastralService;

@RestController
@RequestMapping("/infocadastral")
public class InfoCadastralController {
	
	@Autowired private InfoCadastralService infoCadastralService;
	
	@GetMapping(path = "/users")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public ResponseEntity<List<UserDTO>> findAll() throws IOException {
		return infoCadastralService.findAll();
	}

	@GetMapping(path = "/users/tipo/prestador")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public ResponseEntity<List<UserDTO>> findPrestadores() throws IOException {
		return infoCadastralService.findPrestadores();
	}
	
	@GetMapping(path = "/users/tipo/associado")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public ResponseEntity<List<UserDTO>> findAssociados() throws IOException {
		return infoCadastralService.findAssociados();
	}
	
}
