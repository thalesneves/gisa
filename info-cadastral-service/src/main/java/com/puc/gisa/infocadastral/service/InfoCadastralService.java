package com.puc.gisa.infocadastral.service;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.puc.gisa.infocadastral.domain.dto.UserDTO;
import com.puc.gisa.infocadastral.domain.entity.UserEntity;
import com.puc.gisa.infocadastral.repository.InfoCadastralRepository;

@Service
public class InfoCadastralService {
	
	@Autowired InfoCadastralRepository infoCadastralRepository;
	
	public Page<UserDTO> findAll(Pageable pagination) throws IOException {
		Page<UserEntity> users = infoCadastralRepository.findAll(pagination);
		return UserDTO.converter(users);
	}
	
	public Page<UserDTO> findByTipo(String tipo, Pageable pagination) throws IOException {
		Page<UserEntity> users = infoCadastralRepository.findByTipo(tipo, pagination);
		return UserDTO.converter(users);
	}
	
	public Page<UserDTO> findByCargo(String cargo, Pageable pagination) throws IOException {
		Page<UserEntity> users = infoCadastralRepository.findByCargoContains(cargo, pagination);
		return UserDTO.converter(users);
	}
	
	public ResponseEntity<UserDTO> save(UserDTO userDTO, UriComponentsBuilder uriBuilder) {
		UserEntity userEntity = new UserEntity(userDTO);
		infoCadastralRepository.save(userEntity);
		
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(userEntity.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDTO(userEntity));
	}
	
	public ResponseEntity<UserDTO> edit(Long id, UserDTO userDTO) {
		Optional<UserEntity> carOptional = infoCadastralRepository.findById(id);
		
		if (carOptional.isPresent()) {
			UserEntity user = userDTO.edit(id, infoCadastralRepository);
			
			return ResponseEntity.ok(new UserDTO(user));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<?> delete(Long id) {
		Optional<UserEntity> optional = infoCadastralRepository.findById(id);
		
		if (optional.isPresent()) {
			infoCadastralRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
