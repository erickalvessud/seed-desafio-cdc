package com.deveficiente.controller.dto;

import org.springframework.util.Assert;

import com.deveficiente.jpa.entity.AutorEntity;
import com.deveficiente.jpa.entity.LivroEntity;

import lombok.Getter;

@Getter
public class DetalheAutorResponse {
	
	private String autor;
	private String descricao;

	public DetalheAutorResponse(AutorEntity autorEntity) {
		Assert.state(autorEntity != null, "autorEntity nao deveria ter vindo nulo nesse ponto");
		
		this.autor = autorEntity.getNome();
		this.descricao = autorEntity.getDescricao();
	}
}