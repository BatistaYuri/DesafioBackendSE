package br.com.softexpert.desafio.validator.util;

public class Rules {
    @SuppressWarnings({ "rawtypes" })
    public static ValidationRule custom(Object value, Validation validation, String message) {
        return custom(value, validation, message, null);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ValidationRule custom(Object value, Validation validation, String message, String field) {
        return new ValidationRule(value, validation, message, field);
    }
}
