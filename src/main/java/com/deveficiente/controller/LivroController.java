package com.deveficiente.controller;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.LivroResponse;
import com.deveficiente.controller.dto.NovoLivroRequest;
import com.deveficiente.jpa.entity.LivroEntity;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private EntityManager manager;
	
	public LivroController(EntityManager manager) {
		this.manager = manager;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	//1
	public void cadastrar(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
		this.manager.persist(novoLivroRequest.toEntity(manager));
	}
	
	@GetMapping
	// 2
	public  ResponseEntity<List<LivroResponse>> consultar() {
		List<LivroResponse> livroResponses = this.manager.createQuery("SELECT l FROM LivroEntity l", LivroEntity.class)
			.getResultList().stream()
			.map(LivroResponse::fromEntity)
			.collect(Collectors.toList());
		
		return ResponseEntity.ok(livroResponses);
	}
}
