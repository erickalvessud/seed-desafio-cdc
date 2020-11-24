package com.deveficiente.controller.dto;

import lombok.Getter;

@Getter
public class FieldErrorOutputDto {

	private String field;
	private String errorMessage;

	public FieldErrorOutputDto(String field, String errorMessage) {
		this.field = field;
		this.errorMessage = errorMessage;
	}

}
