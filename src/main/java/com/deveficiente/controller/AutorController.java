package com.deveficiente.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.AutorRequest;
import com.deveficiente.controller.dto.AutorResponse;
import com.deveficiente.jpa.entity.AutorEntity;
import com.deveficiente.jpa.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	private AutorRepository autorRepository;

	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public AutorResponse cadastra(@RequestBody @Validated AutorRequest autor) {
		AutorEntity autorSalvo = this.autorRepository.save(autor.toEntity());
		return AutorResponse.fromEntity(autorSalvo);
	}
	
}
