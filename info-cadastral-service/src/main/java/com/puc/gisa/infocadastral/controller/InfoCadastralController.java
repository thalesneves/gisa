package com.puc.gisa.infocadastral.controller;

import java.io.IOException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.puc.gisa.infocadastral.domain.dto.UserDTO;
import com.puc.gisa.infocadastral.service.InfoCadastralService;

@RestController
@RequestMapping("/infocadastral")
public class InfoCadastralController {
	
	@Autowired private InfoCadastralService infoCadastralService;
	
	@GetMapping(path = "/users")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public Page<UserDTO> findAll(@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 10) Pageable pagination) throws IOException {
		return infoCadastralService.findAll(pagination);
	}

	@GetMapping(path = "/users/{tipo}")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public Page<UserDTO> findByTipo(@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 10) Pageable pagination,
			@PathVariable String tipo) throws IOException {
		return infoCadastralService.findByTipo(tipo, pagination);
	}
	
	@GetMapping(path = "/users/filter")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public Page<UserDTO> findByCargo(@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 10) Pageable pagination,
			@RequestParam("cargo") String cargo) throws IOException {
		return infoCadastralService.findByCargo(cargo, pagination);
	}
	
	@PostMapping(path = "/user")
	@Transactional
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public ResponseEntity<UserDTO> save(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder uriBuilder) {
		return infoCadastralService.save(userDTO, uriBuilder);
	}
	
	@PutMapping(path = "/user/{id}")
	@Transactional
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public ResponseEntity<UserDTO> edit(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) {
		return infoCadastralService.edit(id, userDTO);
	}
	
	@DeleteMapping(path = "/user/{id}")
	@Transactional
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return infoCadastralService.delete(id);
	}
	
}
