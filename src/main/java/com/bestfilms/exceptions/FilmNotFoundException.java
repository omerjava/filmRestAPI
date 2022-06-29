package com.bestfilms.exceptions;

public class FilmNotFoundException extends RuntimeException {

    public FilmNotFoundException(Long id) {
        super("Could not find film " + id);
    }

}
