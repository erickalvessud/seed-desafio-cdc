package com.deveficiente.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import com.deveficiente.jpa.entity.AutorEntity;
import com.deveficiente.jpa.entity.CategoriaEntity;
import com.deveficiente.jpa.entity.LivroEntity;
import com.deveficiente.util.ExistsId;
import com.deveficiente.util.UniqueValeu;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
// 2 pontos de carca intrinseca
public class NovoLivroRequest {

	@NotBlank
	@UniqueValeu(domainClass = LivroEntity.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank 
	@Length(max = 500)
	private String resumo;
	
	@NotBlank 
	private String sumario;
	
	@NotNull
	@DecimalMin(value = "20.0")
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private Integer numeroPagina;
	
	@NotBlank
	@UniqueValeu(domainClass = LivroEntity.class, fieldName = "isbn")
	private String isbn;
	
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@ExistsId(domainClass = CategoriaEntity.class, fieldName = "id")
	private Long idCategoria;
	
	@NotNull
	@ExistsId(domainClass = AutorEntity.class, fieldName = "id")
	private Long idAutor;
	
	@JsonCreator
	public NovoLivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPagina, String isbn,
			LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPagina = numeroPagina;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	@Override
	public String toString() {
		return "NovoLivroRequest [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroPagina=" + numeroPagina + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", idCategoria=" + idCategoria + ", idAutor=" + idAutor + "]";
	}

	//2
	public Object toEntity(EntityManager manager) {
		@NotNull AutorEntity autorEntity = manager.find(AutorEntity.class, idAutor);
		@NotNull CategoriaEntity categoriaEntity = manager.find(CategoriaEntity.class, idCategoria);
		
		Assert.state(autorEntity != null, "Tentativa de cadastrar um livro para um autor inexistente no banco de dados. ID Autor "+ idAutor);
		Assert.state(autorEntity != null, "Tentativa de cadastrar um livro para uma categoria inexistente no banco de dados. ID Categoria "+ idAutor);
		
		return LivroEntity.builder()
				.titulo(titulo)
				.resumo(resumo)
				.sumario(sumario)
				.preco(preco)
				.numeroPagina(numeroPagina)
				.isbn(isbn)
				.dataPublicacao(dataPublicacao)
				.autorEntity(autorEntity)
				.categoriaEntity(categoriaEntity)
				.build();
	}
}
