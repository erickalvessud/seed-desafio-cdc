package com.deveficiente.controller.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaRequest {

	@NotBlank
	private String nome;

	@JsonCreator
	public CategoriaRequest(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}


}
