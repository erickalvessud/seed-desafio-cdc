package com.deveficiente.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.deveficiente.controller.dto.CategoriaRequest;
import com.deveficiente.jpa.repository.CategoriaRepository;

@Component
public class CategoriaProibeNomeDuplicaoValidator implements Validator {

	private CategoriaRepository categoriaRepository;

	public CategoriaProibeNomeDuplicaoValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {		
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaRequest categoriaRequest = (CategoriaRequest) target;
		
		if (this.categoriaRepository.existsByNome(categoriaRequest.getNome())) {
			errors.rejectValue("nome", "Não é permitido cadastrar uma categoria com um nome já existente");
		}
	}

	

}
