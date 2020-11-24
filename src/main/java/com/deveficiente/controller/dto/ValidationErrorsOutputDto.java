package com.deveficiente.controller.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ValidationErrorsOutputDto {
	
    private List<String> globalErrorMessages = new ArrayList<>();
    private List<FieldErrorOutputDto> fieldErrors = new ArrayList<>();

	public void addError(String errorMessage) {
		this.globalErrorMessages.add(errorMessage);
	}

	public void addFieldError(String field, String errorMessage) {
		FieldErrorOutputDto fieldErrorDto = new FieldErrorOutputDto(field, errorMessage);
		this.fieldErrors.add(fieldErrorDto);
	}
	
	public int getNumberOfErrors() {
		return this.globalErrorMessages.size() + this.fieldErrors.size();
	}

}
