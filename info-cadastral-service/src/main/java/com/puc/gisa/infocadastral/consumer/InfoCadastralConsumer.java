package com.puc.gisa.infocadastral.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puc.gisa.infocadastral.constants.RabbitMQConstants;
import com.puc.gisa.infocadastral.dto.UserDTO;

@Component
public class InfoCadastralConsumer {
	
	@RabbitListener(queues = RabbitMQConstants.FILA_INFO_CADASTRAL)
	private void consumidor(String mensagem) throws InterruptedException, JsonMappingException, JsonProcessingException {
		UserDTO userDTO = new ObjectMapper().readValue(mensagem, UserDTO.class);
		System.out.println("-------------------------------------------------");
		System.out.println("Nome: " + userDTO.getNome());
		System.out.println("-------------------------------------------------");
		Thread.sleep(30000);
	}

}
