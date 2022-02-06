package com.puc.gisa.infocadastral.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.puc.gisa.infocadastral.domain.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="users")
public class UserEntity extends AbstractEntity {
	
	@Column(name = "tipo")
	@NotNull @NotEmpty
    private String tipo;
	
    @Column(name = "plano")
    @NotNull @NotEmpty
    private String plano;
    
    @Column(name = "categoria")
    @NotNull @NotEmpty
    private String categoria;

    @Column(name = "nome")
    @NotNull @NotEmpty
    private String nome;
    
    @Column(name = "cargo")
    @NotNull @NotEmpty
    private String cargo;
    
    @Column(name = "telefone")
    @NotNull @NotEmpty
    private String telefone;
    
    @Column(name = "localizacao")
    @NotNull @NotEmpty
    private String localizacao;
    
    @Column(name = "formacao")
    @NotNull @NotEmpty
    private String formacao;
    
    public UserEntity(UserDTO userDTO) {
    	this.tipo = userDTO.getTipo();
		this.plano = userDTO.getPlano();
		this.categoria = userDTO.getCategoria();
		this.nome = userDTO.getNome();
		this.cargo = userDTO.getCargo();
		this.telefone = userDTO.getTelefone();
		this.localizacao = userDTO.getLocalizacao();
		this.formacao = userDTO.getFormacao();
    }
    
}
