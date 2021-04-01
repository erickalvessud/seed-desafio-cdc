package com.deveficiente.controller.dto;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class PedidoRequest {

	@NotNull
	@Positive
	private BigDecimal total;
	
	@NotNull
	@Size(min = 1)
	private Set<@Valid ItensPedidoRequest> itens;
}
