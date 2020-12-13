package com.deveficiente.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.deveficiente.controller.dto.DetalheLivroResponse;
import com.deveficiente.jpa.entity.LivroEntity;
import com.deveficiente.jpa.repository.LivroRepository;


@RestController
public class DetalheLivroController {

	private LivroRepository livroRepository;

	public DetalheLivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@GetMapping("livros/{id}")
	public ResponseEntity<DetalheLivroResponse> consultaDetalhe(@PathVariable("id") Long id) {
		LivroEntity livroEntity = this.livroRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		DetalheLivroResponse detalheLivroResponse = new DetalheLivroResponse(livroEntity);
		
		return ResponseEntity.ok(detalheLivroResponse);
	}
}
