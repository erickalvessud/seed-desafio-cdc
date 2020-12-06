package com.deveficiente.controller.dto;

import javax.validation.constraints.NotBlank;

import com.deveficiente.jpa.entity.CategoriaEntity;
import com.deveficiente.util.UniqueValeu;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaRequest {

	@NotBlank
	@UniqueValeu(fieldName = "nome", domainClass = CategoriaEntity.class)
	private String nome;

	@JsonCreator
	public CategoriaRequest(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}


}
