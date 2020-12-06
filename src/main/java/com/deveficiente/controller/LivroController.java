package com.deveficiente.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.NovoLivroRequest;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
		System.out.println(novoLivroRequest);
	}

}
