package com.allen.dubbo.xml.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

public final class BeanValidator {

    private static javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static void validate(Object params, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(params, groups);
        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            for (ConstraintViolation<Object> validation : constraintViolations) {
                throw new ParameterErrorException(validation.getMessage());
            }
        }
    }

}
