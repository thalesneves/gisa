package com.puc.gisa.infocadastral.domain.dto;

import java.io.Serializable;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.puc.gisa.infocadastral.domain.entity.UserEntity;
import com.puc.gisa.infocadastral.repository.InfoCadastralRepository;

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
	
	public UserDTO(UserEntity userEntity) {
    	this.tipo = userEntity.getTipo();
		this.plano = userEntity.getPlano();
		this.categoria = userEntity.getCategoria();
		this.nome = userEntity.getNome();
		this.cargo = userEntity.getCargo();
		this.telefone = userEntity.getTelefone();
		this.localizacao = userEntity.getLocalizacao();
		this.formacao = userEntity.getFormacao();
	}
	
	public static Page<UserDTO> converter(Page<UserEntity> userEntity) {
		return userEntity.map(UserDTO::new);
	}
	
	public UserEntity edit(Long id, InfoCadastralRepository infoCadastralRepository) {
		UserEntity user = infoCadastralRepository.getById(id);
		user.setTipo(this.tipo);
		user.setPlano(this.plano);
		user.setCategoria(this.categoria);
		user.setNome(this.nome);
		user.setCargo(this.cargo);
		user.setTelefone(this.telefone);
		user.setLocalizacao(this.localizacao);
		user.setFormacao(this.formacao);
		
		return user;
	}
	
}
