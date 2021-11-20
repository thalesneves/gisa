package com.puc.gisa.servicosaoassociado.service;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.puc.gisa.servicosaoassociado.domain.entity.FileEntity;
import com.puc.gisa.servicosaoassociado.repository.FileStorageRepository;

@Service
public class FileStorageService {
	
	@Autowired
	private FileStorageRepository fileRepository;
	
	public ResponseEntity<String> saveFile(MultipartFile file, String flowName, UriComponentsBuilder uriBuilder) {
		
		try {
			FileEntity document = new FileEntity(flowName, file.getOriginalFilename(), file.getContentType(), new Date(), file.getBytes());
			fileRepository.save(document);
			
			URI uri = uriBuilder.path("/file/{id}").buildAndExpand(document.getId()).toUri();
			return ResponseEntity.created(uri).body("{}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Optional<FileEntity> getFile(Long id) {
		return fileRepository.findById(id);
	}
	
	public List<FileEntity> getFiles() {
		return fileRepository.findAll();
	}

}
