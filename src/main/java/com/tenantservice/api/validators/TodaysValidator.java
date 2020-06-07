package com.tenantservice.api.validators;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TodaysValidator implements ConstraintValidator<TodaysDateConstraint, LocalDate>{
	@Override
    public void initialize(TodaysDateConstraint today) {
    }
 
    public boolean isValid(LocalDate contactField,
      ConstraintValidatorContext cxt) {
        return contactField.equals(LocalDate.now());
    }
}