package com.deveficiente.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.StringUtils;

public class DocumentValidator implements ConstraintValidator<Document, String> {

	@Override
	public boolean isValid(String documento, ConstraintValidatorContext context) {
		if (StringUtils.hasLength(documento)) {
		
			CPFValidator cpfValidator = new CPFValidator();
			CNPJValidator cnpjValidator = new CNPJValidator();
			cpfValidator.initialize(null);
			cnpjValidator.initialize(null);
			
			return cpfValidator.isValid(documento, context) || cnpjValidator.isValid(documento, context) ;
		}
		return true;
	}

}
