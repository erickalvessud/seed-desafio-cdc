package com.deveficiente.controller.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.deveficiente.jpa.entity.AutorEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class AutorRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank @Email
	private String email;
	
	@NotBlank @Length(max = 400)
	private String descricao;
	

	public AutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Length(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	
	public AutorEntity toEntity() {
		return new AutorEntity(this.nome, this.email, this.descricao);
	}

}
