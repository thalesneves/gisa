package com.puc.gisa.infocadastral.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private String plano;
	private String categoria;
	private String nome;
	private String cargo;
	private String telefone;
	private String localizacao;
	private String formacao;
	
}
