package com.deveficiente.controller;

import javax.validation.Valid;

import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.PagamentoRequest;
import com.deveficiente.util.EstadoValidator;

@RestController
public class PagamentoCompraController {

	private EstadoValidator estadoValidator;

	public PagamentoCompraController(EstadoValidator estadoValidator) {
		this.estadoValidator = estadoValidator;
	}

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
	    webDataBinder.addValidators(estadoValidator);
    }
	
	@PostMapping(path = "/pagamento-compra")
	public void efetuaPagamento(@RequestBody @Valid PagamentoRequest pagamentoRequest) {
		System.out.println(pagamentoRequest);
	}
	
}
