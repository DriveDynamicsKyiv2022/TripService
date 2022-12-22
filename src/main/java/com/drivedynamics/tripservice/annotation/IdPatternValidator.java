package com.drivedynamics.tripservice.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdPatternValidator implements
        ConstraintValidator<IdStringConstraint, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.matches("[a-z0-9]{1,24}");
    }
}
