package com.puc.gisa.comunicacaolegado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.puc.gisa.comunicacaolegado.constants.RabbitMQConstants;
import com.puc.gisa.comunicacaolegado.dto.UserDTO;

@Service
public class ComunicacaoLegadoService {
	
	@Autowired private RabbitMQService rabbitMQService;

	public ResponseEntity<String> send(UserDTO userDTO) {
		this.rabbitMQService.enviaMensagem(RabbitMQConstants.FILA_INFO_CADASTRAL, userDTO);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
