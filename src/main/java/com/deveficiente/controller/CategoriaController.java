package com.deveficiente.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.CategoriaRequest;
import com.deveficiente.controller.validator.CategoriaProibeNomeDuplicaoValidator;
import com.deveficiente.jpa.entity.CategoriaEntity;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private EntityManager entityManager;
	private CategoriaProibeNomeDuplicaoValidator categoriaProibeNomeDuplicadovalidator;

	public CategoriaController(EntityManager entityManager, CategoriaProibeNomeDuplicaoValidator validator) {
		this.entityManager = entityManager;
		this.categoriaProibeNomeDuplicadovalidator = validator;
	}
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(categoriaProibeNomeDuplicadovalidator);
		
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	public void cadastra(@RequestBody @Valid @NotBlank CategoriaRequest categoria) {
		this.entityManager.persist(new CategoriaEntity(categoria.getNome()));
	}
}
