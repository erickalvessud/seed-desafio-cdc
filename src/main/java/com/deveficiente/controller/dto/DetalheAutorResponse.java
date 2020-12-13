package com.deveficiente.controller.dto;

import org.springframework.util.Assert;

import com.deveficiente.jpa.entity.LivroEntity;

import lombok.Getter;

@Getter
public class DetalheAutorResponse {
	
	private String autor;
	private String descricao;

	public DetalheAutorResponse(LivroEntity livroEntity) {
		Assert.state(livroEntity != null, "LivroEntity nao deveria ter vindo nulo nesse ponto");
		Assert.state(livroEntity.getAutorEntity() != null, "AutorEntity nao deveria ter vindo nulo nesse ponto já que um Livro nao e salvo sem um autor");
		
		this.autor = livroEntity.getAutorEntity().getNome();
		this.descricao = livroEntity.getAutorEntity().getDescricao();
	}
}