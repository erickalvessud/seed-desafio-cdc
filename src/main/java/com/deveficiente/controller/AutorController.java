package com.deveficiente.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.controller.dto.AutorRequest;
import com.deveficiente.controller.dto.AutorResponse;
import com.deveficiente.controller.validator.EmailAutorValidator;
import com.deveficiente.jpa.entity.AutorEntity;
import com.deveficiente.jpa.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	private AutorRepository autorRepository;
	
	private EmailAutorValidator validator;

	public AutorController(AutorRepository autorRepository, EmailAutorValidator validator) {
		this.autorRepository = autorRepository;
		this.validator = validator;
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public AutorResponse cadastra(@RequestBody @Validated AutorRequest autor) {
		AutorEntity autorSalvo = this.autorRepository.save(autor.toEntity());
		return AutorResponse.fromEntity(autorSalvo);
	}
	
}
