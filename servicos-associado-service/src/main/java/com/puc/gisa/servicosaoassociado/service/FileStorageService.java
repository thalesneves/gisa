package com.puc.gisa.servicosaoassociado.service;

import java.net.URI;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.puc.gisa.servicosaoassociado.domain.dto.FileDTO;
import com.puc.gisa.servicosaoassociado.domain.entity.FileEntity;
import com.puc.gisa.servicosaoassociado.domain.vo.FileVO;
import com.puc.gisa.servicosaoassociado.repository.FileStorageRepository;

@Service
public class FileStorageService {
	
	@Autowired private FileStorageRepository fileRepository;
	
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
	
	public Page<FileDTO> getAllFiles(Pageable pagination) {
		Page<FileEntity> files = fileRepository.findAll(pagination);
		return FileDTO.converter(files);
	}
	
	public Optional<FileEntity> getFile(Long id) {
		return fileRepository.findById(id);
	}
	
	public ResponseEntity<?> deleteFile(Long id) {
		Optional<FileEntity> optional = fileRepository.findById(id);
		
		if (optional.isPresent()) {
			fileRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<FileDTO> editFile(Long id, @Valid FileVO fileVO) {
		Optional<FileEntity> optional = fileRepository.findById(id);
		
		if (optional.isPresent()) {
			FileEntity file = fileVO.edit(id, fileRepository);
			
			return ResponseEntity.ok(new FileDTO(file));
		}
		
		return ResponseEntity.notFound().build();
	}

}
