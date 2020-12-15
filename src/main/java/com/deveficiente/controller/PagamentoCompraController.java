package com.deveficiente.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.PagamentoRequest;

@RestController
public class PagamentoCompraController {

	@PostMapping(path = "/pagamento-compra")
	public void efetuaPagamento(@RequestBody @Valid PagamentoRequest pagamentoRequest) {
		System.out.println(pagamentoRequest);
	}
	
}
