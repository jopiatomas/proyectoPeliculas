package com.movies.demo.exceptions;

public class PeliculaYaExisteException extends RuntimeException{
    public PeliculaYaExisteException(String message){
        super(message);
    }
}
