package com.puc.gisa.servicosaoassociado.domain.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.puc.gisa.servicosaoassociado.domain.entity.FileEntity;
import com.puc.gisa.servicosaoassociado.repository.FileStorageRepository;

import lombok.Getter;

@Getter
public class FileVO {
	
	@NotNull @NotEmpty
	private String flowName;
	
	public FileEntity edit(Long id, FileStorageRepository fileStorageRepository) {
		FileEntity file = fileStorageRepository.getById(id);
		file.setFlowName(flowName);
		
		return file;
	}

}
