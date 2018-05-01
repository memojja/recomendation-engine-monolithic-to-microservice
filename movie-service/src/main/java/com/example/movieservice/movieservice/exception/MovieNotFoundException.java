package com.example.movieservice.movieservice.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String s) {
        super(s);
    }
}
