package com.puc.gisa.infocadastral.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.puc.gisa.infocadastral.domain.entity.UserEntity;

public interface InfoCadastralRepository extends JpaRepository<UserEntity, Long> {
	
	Page<UserEntity> findByTipo(String tipo, Pageable paginacao);
	
	Page<UserEntity> findByCargoContains(String cargo, Pageable paginacao);

}
