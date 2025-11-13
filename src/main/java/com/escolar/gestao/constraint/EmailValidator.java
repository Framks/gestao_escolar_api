package com.escolar.gestao.constraint;

import jakarta.validation.ConstraintValidator;

public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9.!#$%&'*+/=?^_`{|}~-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,}$";
        return value.matches(emailRegex);
    }
}
