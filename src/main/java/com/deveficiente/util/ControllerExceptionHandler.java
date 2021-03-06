package com.deveficiente.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.deveficiente.controller.dto.ValidationErrorsOutputDto;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@Autowired
    private MessageSource messageSource;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidationErrorsOutputDto handleValidationError(MethodArgumentNotValidException exception) {
		
		List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		return buildValidationErros(globalErrors, fieldErrors);
	}

	private ValidationErrorsOutputDto buildValidationErros(List<ObjectError> globalErrors,
			List<FieldError> fieldErrors) {

		ValidationErrorsOutputDto validationErrosDto = new ValidationErrorsOutputDto();
		
		globalErrors.forEach(error -> validationErrosDto.addError(getErrorMessage(error)));
		
		fieldErrors.forEach(error -> {
			String errorMessage = getErrorMessage(error);
			System.out.println("error-> "+ errorMessage);
			validationErrosDto.addFieldError(error.getField() , errorMessage);
		});
		
		return validationErrosDto;
	}
	
    private String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }
    
}
