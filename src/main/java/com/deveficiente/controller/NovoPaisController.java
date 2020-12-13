package com.deveficiente.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.PaisRequest;
import com.deveficiente.jpa.entity.PaisEntity;

@RestController
public class NovoPaisController {

	private EntityManager manager;

	public NovoPaisController(EntityManager manager) {
		this.manager = manager;
	}

	@PostMapping(path = "/paises")
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	public void cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
		this.manager.persist(new PaisEntity(paisRequest.getNome()));
	}
}
