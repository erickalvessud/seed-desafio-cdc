package com.deveficiente.controller.dto;

import javax.validation.constraints.NotBlank;

import com.deveficiente.jpa.entity.CategoriaEntity;
import com.deveficiente.util.UniqueValeu;
import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaResponse {

	private Long id;
	private String nome;

	@JsonCreator
	public CategoriaResponse(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}


}
