package com.puc.gisa.servicosaoassociado.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.puc.gisa.servicosaoassociado.domain.entity.FileEntity;
import com.puc.gisa.servicosaoassociado.service.FileStorageService;

@RestController
@RequestMapping("/servicosassociado")
public class FileController {

	@Autowired
	private FileStorageService documentStorageService;
	
	@PostMapping("/uploadfile")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	@Transactional
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("flowName") String flowName, UriComponentsBuilder uriBuilder) {
		return documentStorageService.saveFile(file, flowName, uriBuilder);
	}
	
	@GetMapping("/downloadfile/{fileId}")
	@PreAuthorize("hasAuthority('ROLE_FULL_ACCESS')")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId) {
		FileEntity document = documentStorageService.getFile(fileId).get();
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(document.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + document.getFileName() + "\"")
				.body(new ByteArrayResource(document.getData()));
	}

}
