package com.deveficiente.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;

import com.deveficiente.jpa.entity.AutorEntity;
import com.deveficiente.jpa.entity.CategoriaEntity;
import com.deveficiente.jpa.entity.LivroEntity;
import com.deveficiente.util.ExistsId;
import com.deveficiente.util.UniqueValeu;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LivroResponse {
	
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPagina;
	private String isbn;
	private LocalDate dataPublicacao;
	private AutorResponse autor;
	private CategoriaResponse categoria;

	public static List<LivroResponse> fromEntities(Iterable<LivroEntity> livroEntities) {
		List<LivroResponse> livroResponses = new ArrayList<>();
		
		for(LivroEntity livroEntity :livroEntities) {
			livroResponses.add(fromEntity(livroEntity));
		}
		return livroResponses;
	}

	private static LivroResponse fromEntity(LivroEntity livroEntity) {
		AutorResponse autorResponse = AutorResponse.builder()
			.id(livroEntity.getAutorEntity().getId())
			.nome(livroEntity.getAutorEntity().getNome())
			.descricao(livroEntity.getAutorEntity().getDescricao())
			.email(livroEntity.getAutorEntity().getEmail())
			.dataResgistro(livroEntity.getAutorEntity().getDataResgistro())
			.build();
		
		CategoriaResponse categoriaResponse = CategoriaResponse.builder()
				.id(livroEntity.getCategoriaEntity().getId())
				.nome(livroEntity.getCategoriaEntity().getNome())
				.build();
		
		return LivroResponse.builder()
				.id(livroEntity.getId())
				.titulo(livroEntity.getTitulo())
				.resumo(livroEntity.getResumo())
				.sumario(livroEntity.getSumario())
				.preco(livroEntity.getPreco())
				.numeroPagina(livroEntity.getNumeroPagina())
				.isbn(livroEntity.getIsbn())
				.dataPublicacao(livroEntity.getDataPublicacao())
				.autor(autorResponse)
				.categoria(categoriaResponse)
				.build();
		
	}

}
