package com.deveficiente.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object>{

	@PersistenceContext
	private EntityManager manager;
	
	private Class<?> domainClass;
	private String fieldName;

	@Override
	public void initialize(ExistsId constraintAnnotation) {
		this.domainClass = constraintAnnotation.domainClass();
		this.fieldName = constraintAnnotation.fieldName();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		TypedQuery<?> query = this.manager.createQuery("SELECT t FROM " + domainClass.getSimpleName() + " t WHERE t." + fieldName + " = :fieldName" , domainClass);
		query.setParameter("fieldName", value);
		List<?> resultList = query.getResultList();
		
		return !resultList.isEmpty();
	}

}
