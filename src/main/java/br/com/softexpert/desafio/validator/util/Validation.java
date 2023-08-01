package br.com.softexpert.desafio.validator.util;

public interface Validation<T> {

    boolean isInvalid(T value);

}
