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

import org.hibernate.validator.constraints.Length;

import com.deveficiente.controller.dto.AutorDTO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "autor")
@Data
@Builder
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
}
