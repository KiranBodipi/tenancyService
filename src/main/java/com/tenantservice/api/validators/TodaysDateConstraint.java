package com.tenantservice.api.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = {TodaysValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TodaysDateConstraint {

	String message() default "Created By Date must be Today's Date.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
