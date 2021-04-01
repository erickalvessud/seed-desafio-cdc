package com.deveficiente.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.deveficiente.jpa.entity.LivroEntity;
import com.deveficiente.jpa.entity.PaisEntity;
import com.deveficiente.util.ExistsId;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ItensPedidoRequest {

	@NotNull
	@ExistsId(domainClass = LivroEntity.class, fieldName = "id")
	private Long idLivro;
	
	@NotNull
	@Positive
	private int quantidade;
}
