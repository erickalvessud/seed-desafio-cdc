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
import com.deveficiente.jpa.entity.CategoriaEntity;

@RestController
@RequestMapping("/categorias")
//carga intrinseca 2
public class CategoriaController {

	private EntityManager entityManager;

	public CategoriaController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	//2
	public void cadastra(@RequestBody @Valid @NotBlank CategoriaRequest categoria) {
		this.entityManager.persist(new CategoriaEntity(categoria.getNome()));
	}
}
