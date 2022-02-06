package com.puc.gisa.infocadastral.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorFormDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String field;
	private String error;

}
