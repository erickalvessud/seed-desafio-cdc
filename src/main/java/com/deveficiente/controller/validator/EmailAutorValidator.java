package com.deveficiente.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.deveficiente.controller.dto.AutorRequest;
import com.deveficiente.jpa.repository.AutorRepository;

@Component
public class EmailAutorValidator implements Validator {

	private AutorRepository autorRepository;
	
	public EmailAutorValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		AutorRequest autorRequest = ((AutorRequest)target);
		
		if ( this.autorRepository.existsByEmail(autorRequest.getEmail())) {
			errors.rejectValue("email", "Email já cadastrado no sistema");
		}
	}

}
