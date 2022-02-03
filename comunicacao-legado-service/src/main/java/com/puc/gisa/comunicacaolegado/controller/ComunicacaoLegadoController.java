package com.puc.gisa.comunicacaolegado.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.gisa.comunicacaolegado.dto.UserDTO;
import com.puc.gisa.comunicacaolegado.service.ComunicacaoLegadoService;

@RestController
@RequestMapping("/comunicacaolegado")
public class ComunicacaoLegadoController {
	
	@Autowired private ComunicacaoLegadoService comunicacaoLegadoService;
	
	@PostMapping("/user")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	@Transactional
	public ResponseEntity<String> send(@RequestBody @Valid UserDTO userDTO) throws IOException {
		return comunicacaoLegadoService.send(userDTO);
	}
	
}
