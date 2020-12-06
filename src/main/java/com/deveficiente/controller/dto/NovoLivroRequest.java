package com.deveficiente.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class NovoLivroRequest {

	@NotBlank
	private String titulo;
	
	@NotBlank 
	@Length(max = 500)
	private String resumo;
	private String sumario;
	
	@NotNull
	@DecimalMin(value = "20.0")
	private BigDecimal preco;
	private Integer numeroPagina;
	private String isbn;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	private Long idCategoria;
	private Long idAutor;
	
	@JsonCreator
	public NovoLivroRequest(String titulo, String resumo, BigDecimal preco, Integer numeroPagina, String isbn,
			LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
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
	

}
