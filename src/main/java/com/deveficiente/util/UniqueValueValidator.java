package com.deveficiente.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValeu, Object> {

	@PersistenceContext
	private EntityManager manager;
	
	private Class<?> clazz;
	private String fieldName;
	
	
	@Override
	public void initialize(UniqueValeu constraintAnnotation) {
		this.fieldName = constraintAnnotation.fieldName();
		this.clazz = constraintAnnotation.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		TypedQuery<?> query = this.manager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t WHERE t."+ this.fieldName +" = :value", clazz);
		query.setParameter("value", value);
		List<?> results = query.getResultList();
		
		Assert.state(results.size() <= 1, "Foi encontrado mais de um "+clazz+" com o atributo "+ this.fieldName);
		
		return results.isEmpty();
	}

}
