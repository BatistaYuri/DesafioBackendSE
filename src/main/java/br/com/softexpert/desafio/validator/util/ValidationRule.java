package br.com.softexpert.desafio.validator.util;

public class ValidationRule<T> {

    private T value;
    private Validation<T> validation;
    private String message;
    private String field;

    public ValidationRule(T value, Validation<T> validation, String message) {
        this(value, validation, message, null);
    }

    public ValidationRule(T value, Validation<T> validation, String message, String field) {
        this.value = value;
        this.validation = validation;
        this.message = message;
        this.field = field;
    }

    public T getValue() {
        return value;
    }

    public Validation<T> getValidation() {
        return validation;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }
}
