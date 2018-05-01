package com.jcombat.profile.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String s) {
        super(s);
    }
}
