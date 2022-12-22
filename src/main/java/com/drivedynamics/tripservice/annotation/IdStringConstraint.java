package com.drivedynamics.tripservice.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IdPatternValidator.class)
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface IdStringConstraint {
    String message() default "Invalid id string";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
