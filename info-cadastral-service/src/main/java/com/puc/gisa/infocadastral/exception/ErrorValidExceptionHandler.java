package com.puc.gisa.infocadastral.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.puc.gisa.infocadastral.domain.dto.ErrorFormDTO;

@RestControllerAdvice
public class ErrorValidExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorFormDTO> handler(MethodArgumentNotValidException exception) {
		List<ErrorFormDTO> errorsDto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(error -> { 
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			errorsDto.add(new ErrorFormDTO(error.getField(), message));
		});
		
		return errorsDto;
	}
	
}
