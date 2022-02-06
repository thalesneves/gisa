package com.puc.gisa.infocadastral.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class AbstractEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

}
