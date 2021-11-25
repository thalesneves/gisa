package com.puc.gisa.servicosaoassociado.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.puc.gisa.servicosaoassociado.domain.dto.FileDTO;
import com.puc.gisa.servicosaoassociado.domain.entity.FileEntity;
import com.puc.gisa.servicosaoassociado.domain.vo.FileVO;
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
			@RequestParam(name = "flowName", required = true) String flowName, UriComponentsBuilder uriBuilder) {
		return documentStorageService.saveFile(file, flowName, uriBuilder);
	}
	
	@GetMapping
	public Page<FileDTO> getAllFiles(@PageableDefault(sort = "flowName", direction = Direction.DESC, page = 0, size = 10) Pageable pagination) {
		return documentStorageService.getAllFiles(pagination);
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
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return documentStorageService.deleteFile(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FileDTO> edit(@PathVariable Long id, @RequestBody @Valid FileVO fileVO) {
		return documentStorageService.editFile(id, fileVO);
	}

}
