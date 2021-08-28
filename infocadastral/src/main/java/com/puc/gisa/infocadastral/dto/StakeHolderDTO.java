package com.puc.gisa.infocadastral.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StakeHolderDTO {
	
	private String tipo;
	private String plano;
	private String nome;
	private String cargo;
	private String telefone;
	private String localizacao;
	private String formacao;
}
