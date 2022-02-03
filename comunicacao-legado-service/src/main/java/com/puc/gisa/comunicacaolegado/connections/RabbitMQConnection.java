package com.puc.gisa.comunicacaolegado.connections;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import com.puc.gisa.comunicacaolegado.constants.RabbitMQConstants;

@Component
public class RabbitMQConnection {
	
	private final String NOME_EXCHANGE = "amq.direct";
	
	private AmqpAdmin amqpAdmin;
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}
	
	private Queue fila(String nomeFile) {
		return new Queue(nomeFile);
	}
	
	private DirectExchange trocaDireta() {
		return new DirectExchange(NOME_EXCHANGE);
	}
	
	private Binding relacionamento(Queue fila, DirectExchange troca) {
		return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
	}
	
	@PostConstruct
	private void adiciona() {
		Queue filaInfoCadastral = this.fila(RabbitMQConstants.FILA_INFO_CADASTRAL);
		
		DirectExchange troca = this.trocaDireta();
		
		Binding relacionamento = this.relacionamento(filaInfoCadastral, troca);
		
		this.amqpAdmin.declareQueue(filaInfoCadastral);
		this.amqpAdmin.declareExchange(troca);
		this.amqpAdmin.declareBinding(relacionamento);
	}
	
}
