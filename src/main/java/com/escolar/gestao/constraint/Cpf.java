package com.escolar.gestao.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidator.class)
@Target({ElementType.FIELD,  ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpf {
    String message() default "Email invalid"; // vai ficar pendente melhorar a criação da mensagem de erro

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}