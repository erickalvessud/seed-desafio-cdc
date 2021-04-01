package com.deveficiente.controller;

import javax.validation.Valid;

import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.CompraRequest;
import com.deveficiente.util.EstadoValidator;
import com.deveficiente.util.ValorTotalLivroValidator;

@Validated
@RestController
public class CompraController {

	private EstadoValidator estadoValidator;
	private  ValorTotalLivroValidator valorTotalLivroValidator;

	public CompraController(EstadoValidator estadoValidator, ValorTotalLivroValidator valorTotalLivroValidator) {
		this.estadoValidator = estadoValidator;
		this.valorTotalLivroValidator = valorTotalLivroValidator;
	}

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
	    webDataBinder.addValidators(estadoValidator, valorTotalLivroValidator);
    }
	
	@PostMapping(path = "/compra")
	public void efetuaCompra(@RequestBody @Valid CompraRequest compraRequest) {
		System.out.println(compraRequest);
	}
	
}
