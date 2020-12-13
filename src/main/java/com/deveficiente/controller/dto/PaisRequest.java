package com.deveficiente.controller.dto;

import javax.validation.constraints.NotBlank;

import com.deveficiente.jpa.entity.PaisEntity;
import com.deveficiente.util.UniqueValeu;
import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public class PaisRequest {
	
	@NotBlank
	@UniqueValeu(fieldName = "nome", domainClass = PaisEntity.class)
	private String nome;

	@JsonCreator
	public PaisRequest(String nome) {
		this.nome = nome;
	}

}
