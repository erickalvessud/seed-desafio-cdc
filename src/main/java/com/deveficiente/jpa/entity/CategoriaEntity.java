package com.deveficiente.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.Assert;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "categoria")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@EqualsAndHashCode.Include
	private String nome;
	
	@Deprecated
	public CategoriaEntity() {
	}

	public CategoriaEntity(@NotBlank String nome) {
		Assert.hasLength(nome
				, "Atributo nome não deve ser vazio ou nulo");
		
		this.nome = nome;
	}
}
