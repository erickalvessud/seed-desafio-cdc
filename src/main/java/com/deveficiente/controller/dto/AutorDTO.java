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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AutorDTO {

	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank @Email
	private String email;
	
	@NotBlank @Length(max = 400)
	private String descricao;

	private LocalDateTime dataResgistro;
	
	public AutorEntity toEntity() {
		return AutorEntity.builder()
			.nome(this.getNome())
			.email(this.email)
			.descricao(this.descricao)
			.build();
	}
	
	public static AutorDTO fromEntity(AutorEntity autorEntity) {
		
		return AutorDTO.builder()
				.id(autorEntity.getId())
				.nome(autorEntity.getNome())
				.email(autorEntity.getEmail())
				.descricao(autorEntity.getDescricao())
				.dataResgistro(autorEntity.getDataResgistro())
				.build();
	}
}
