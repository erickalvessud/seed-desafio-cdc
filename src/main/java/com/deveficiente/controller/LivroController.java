package com.deveficiente.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.NovoLivroRequest;
import com.deveficiente.jpa.repository.AutorRepository;
import com.deveficiente.jpa.repository.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private EntityManager manager;
	private AutorRepository autorRepository;
	private CategoriaRepository categoriaRepository;
	
	public LivroController(EntityManager manager, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		this.manager = manager;
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	public void cadastrar(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
		manager.persist(novoLivroRequest.toEntity(autorRepository, categoriaRepository));
	}

}
