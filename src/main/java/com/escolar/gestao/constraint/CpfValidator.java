package com.escolar.gestao.constraint;

import jakarta.validation.ConstraintValidator;

public class CpfValidator implements ConstraintValidator<Cpf, String> {

    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return isValidCpf(value) ;
    }

    private boolean isValidCpf(String cpf){
        try{
            // Calcula o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int primeiroDV = 11 - (soma % 11);
            if (primeiroDV >= 10) primeiroDV = 0;

            // Calcula o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            int segundoDV = 11 - (soma % 11);
            if (segundoDV >= 10) segundoDV = 0;

            return primeiroDV == (cpf.charAt(9) - '0') && segundoDV == (cpf.charAt(10) - '0');
        }catch (Exception e){
            return false;
        }
    }
}
