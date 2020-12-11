package com.deveficiente.controller;

import java.util.List;

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
import com.deveficiente.jpa.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private EntityManager manager;
	private LivroRepository livroRepository;
	
	public LivroController(EntityManager manager,LivroRepository livroRepository) {
		this.manager = manager;
		this.livroRepository = livroRepository;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	public void cadastrar(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
		manager.persist(novoLivroRequest.toEntity(manager));
	}
	
	@GetMapping
	public  ResponseEntity<List<LivroResponse>> consultar() {
		Iterable<LivroEntity> livroEntities = livroRepository.findAll();
		List<LivroResponse> livroResponses = LivroResponse.fromEntities(livroEntities);
		return ResponseEntity.ok(livroResponses);
	}

}
