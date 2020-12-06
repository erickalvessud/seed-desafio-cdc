package com.deveficiente;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.deveficiente.controller.dto.AutorRequest;
import com.deveficiente.jpa.repository.AutorRepository;
import com.sun.jdi.connect.Connector.Argument;

public class EmailAutorValidatorTest {
	
	@Test
	@DisplayName("Nao deve criar um autor com um email ja existente no sistema")
	public void teste1() {
		/*
		 * String emailCadastro = "joao@email.com"; String emailDuplicado =
		 * "joao@email.com";
		 * 
		 * AutorRequest autorRequest = new AutorRequest("Erick", emailCadastro,
		 * "Autor de muitos livros");
		 * 
		 * AutorRepository autorRepository = mock(AutorRepository.class);
		 * 
		 * Errors errors = new BeanPropertyBindingResult(autorRequest, "");
		 * 
		 * when(autorRepository.existsByEmail(emailDuplicado)).thenReturn(true);
		 * 
		 * EmailAutorValidator emailAutorValidator = new
		 * EmailAutorValidator(autorRepository);
		 * 
		 * emailAutorValidator.validate(autorRequest, errors);
		 * 
		 * assertTrue(errors.hasErrors()); assertNotNull(errors.getFieldError("email"));
		 */
	}
	
	@Test
	@DisplayName("deve criar um autor com um email diferente no sistema")
	public void teste2() {
		/*
		 * String emailCadastro = "maria@email.com"; String emailDuplicado =
		 * "joao@email.com";
		 * 
		 * AutorRequest autorRequest = new AutorRequest("Erick", emailCadastro,
		 * "Autor de muitos livros");
		 * 
		 * AutorRepository autorRepository = mock(AutorRepository.class);
		 * 
		 * Errors errors = new BeanPropertyBindingResult(autorRequest, "");
		 * 
		 * when(autorRepository.existsByEmail(emailDuplicado)).thenReturn(true);
		 * 
		 * EmailAutorValidator emailAutorValidator = new
		 * EmailAutorValidator(autorRepository);
		 * 
		 * emailAutorValidator.validate(autorRequest, errors);
		 * 
		 * assertFalse(errors.hasErrors()); assertNull(errors.getFieldError("email"));
		 */
	}
}
