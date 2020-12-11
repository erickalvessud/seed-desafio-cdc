package com.deveficiente.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "livro")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LivroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPagina;
	private String isbn;
	private LocalDate dataPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private AutorEntity autorEntity;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private CategoriaEntity categoriaEntity;
	
	@Deprecated
	public LivroEntity() {
		super();
	}
/*
	public LivroEntity(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo,
			@NotNull @DecimalMin("20.0") BigDecimal preco, @NotNull @Min(100) Integer numeroPagina,
			@NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull AutorEntity autorEntity,
			@NotNull CategoriaEntity categoriaEntity) {
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.numeroPagina = numeroPagina;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autorEntity = autorEntity;
		this.categoriaEntity = categoriaEntity;
	}
*/
}
