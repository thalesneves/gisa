package com.puc.gisa.servicosaoassociado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puc.gisa.servicosaoassociado.domain.entity.FileEntity;

public interface FileStorageRepository extends JpaRepository<FileEntity, Long> {
	
}
