package com.deveficiente.controller.dto;

import java.math.BigDecimal;

import org.springframework.util.Assert;

import com.deveficiente.jpa.entity.LivroEntity;

import lombok.Getter;

@Getter
public class DetalheLivroResponse {
	
	private String titulo;
	private String resumo;
	private BigDecimal preco;
	private String sumario;
	private Integer numeroPagina;
	private String isbn;
	private DetalheAutorResponse autor;
	
	public DetalheLivroResponse(LivroEntity livroEntity) {
		Assert.state(livroEntity != null, "LivroEntity nao deveria ter vindo nulo nesse ponto");
		
		this.titulo = livroEntity.getTitulo();
		this.resumo = livroEntity.getResumo();
		this.preco = livroEntity.getPreco();
		this.sumario = livroEntity.getSumario();
		this.numeroPagina = livroEntity.getNumeroPagina();
		this.isbn = livroEntity.getIsbn();
		this.autor = new DetalheAutorResponse(livroEntity);
	}

}
