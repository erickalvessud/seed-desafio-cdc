package com.deveficiente.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(name = "estado")
@Getter
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EstadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private PaisEntity pais;
	
	@Deprecated
	public EstadoEntity() {
		super();
	}

	public EstadoEntity(@NotBlank String nome, @NotNull PaisEntity pais) {
		Assert.state(nome != null && !nome.isBlank(), "Nome do estado não deveria ser nulo.");
		this.nome = nome;
	}
}
