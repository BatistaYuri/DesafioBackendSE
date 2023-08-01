package br.com.softexpert.desafio.validator.util;

public class Validations {

    private Validations() {

    }

    public static ValidationBuilder start() {
        return new ValidationBuilder();
    }

}

