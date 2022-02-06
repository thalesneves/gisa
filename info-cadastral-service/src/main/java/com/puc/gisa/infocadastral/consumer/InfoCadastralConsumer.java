package com.puc.gisa.infocadastral.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puc.gisa.infocadastral.constants.RabbitMQConstants;
import com.puc.gisa.infocadastral.domain.dto.UserDTO;
import com.puc.gisa.infocadastral.service.InfoCadastralService;

@Component
public class InfoCadastralConsumer {
	
	@Autowired private InfoCadastralService infoCadastralService;
	
	@RabbitListener(queues = RabbitMQConstants.FILA_INFO_CADASTRAL)
	private void consumidor(String mensagem) throws InterruptedException, JsonMappingException, JsonProcessingException {
		UserDTO userDTO = new ObjectMapper().readValue(mensagem, UserDTO.class);
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("############ Novo Usuário Cadastrado ############");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println("Tipo: " + userDTO.getTipo());
		System.out.println("Plano: " + userDTO.getPlano());
		System.out.println("Categoria: " + userDTO.getCategoria());
		System.out.println("Nome: " + userDTO.getNome());
		System.out.println("Cargo: " + userDTO.getCargo());
		System.out.println("Telefone: " + userDTO.getTelefone());
		System.out.println("Localização: " + userDTO.getLocalizacao());
		System.out.println("Formação: " + userDTO.getFormacao());
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("############ Novo Usuário Cadastrado ############");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
		infoCadastralService.save(userDTO, uriBuilder);
	}

}
