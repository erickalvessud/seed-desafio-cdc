package com.deveficiente.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "autor")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AutorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(length = 255, nullable = false)
	private String nome;

	@Column(length = 255, nullable = false)
	private String email;
	
	@Column(length = 400, nullable = false)
	private String descricao;

	@Builder.Default
	private LocalDateTime dataResgistro = LocalDateTime.now();
	
	@Deprecated
	public AutorEntity() {
		
	}

	public AutorEntity(@NotBlank String nome,@NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {

		this.validarAtributosEntrada(nome, email, descricao);

		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	private void validarAtributosEntrada(String nome, String email, String descricao) {
		Assert.hasLength(nome, "Atributo nome não pode ser fazio");

		if ( !EmailValidator.getInstance().isValid(email)) {
			throw new IllegalArgumentException("Atributo e-mail inválido");
		}
		
		Assert.hasLength(descricao, "Atributo descricao não pode ser fazio");
		if (descricao.length() > 400) {
			throw new IllegalArgumentException("Atributo descricao deve ter um tamanho menor ou igual a 400");
		}
	}
	
	
}
