package ru.cataccess.exceptions;

public class CatNotFoundException extends RuntimeException {

    public CatNotFoundException(Long id) {
        super("Could not find cat with id " + id);
    }
}
