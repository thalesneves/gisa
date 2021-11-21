package com.puc.gisa.servicosaoassociado.domain.dto;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.puc.gisa.servicosaoassociado.domain.entity.FileEntity;

import lombok.Getter;

@Getter
public class FileDTO {
	
	private Long id;
    private String flowName;
    private String fileName;
    private Date logDate;
    
    public FileDTO(FileEntity file) {
    	this.id = file.getId();
		this.flowName = file.getFlowName();
		this.fileName = file.getFileName();
		this.logDate = file.getLogDate();
	}
    
    public static Page<FileDTO> converter(Page<FileEntity> files) {
		return files.map(FileDTO::new);
	}
	
}
