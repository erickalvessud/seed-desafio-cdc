package com.deveficiente.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {DocumentValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Document {

	String message() default "{com.deveficiente.beanvalidation.document}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
