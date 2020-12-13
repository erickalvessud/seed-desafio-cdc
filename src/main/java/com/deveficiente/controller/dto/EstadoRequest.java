package com.deveficiente.controller.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.deveficiente.jpa.entity.EstadoEntity;
import com.deveficiente.jpa.entity.PaisEntity;
import com.deveficiente.util.ExistsId;
import com.deveficiente.util.UniqueValeu;
import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public class EstadoRequest {

	@NotBlank
	@UniqueValeu(fieldName = "nome", domainClass = EstadoEntity.class)
	private String nome;
	
	@NotNull
	@ExistsId(fieldName = "id", domainClass = PaisEntity.class)
	private Long idPais;
	
	@JsonCreator
	public EstadoRequest(String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public EstadoEntity toEntity(EntityManager manager) {
		
		@NotNull
		PaisEntity pais = manager.find(PaisEntity.class, idPais);
		
		Assert.state(pais != null, "Pais de id " + idPais + " nao cadastrado no banco de dados");
		
		EstadoEntity estado = new EstadoEntity(this.nome, pais);
		
		return estado;
	}
}
