package com.deveficiente.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.util.Assert;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(name = "pais")
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PaisEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String nome;

	@Deprecated
	public PaisEntity() {
	}
	
	public PaisEntity(@NotBlank String nome) {
		Assert.state(nome != null && !nome.isBlank(), "Nome do país não deveria ser nulo.");
		
		this.nome = nome;
	}
}
