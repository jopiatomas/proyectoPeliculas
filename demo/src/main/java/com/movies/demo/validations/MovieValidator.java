package com.movies.demo.validations;

import com.movies.demo.model.Movie;
import com.movies.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

// agregar excepciones personalizadas y hablar sobre el readme y test postman
@Component
public class MovieValidator {

    @Autowired
    private MovieRepository movieRepository;

    public void validarParaCreacion(Movie movie){
        if(movie.getAnioLanzamiento() < 1920 && movie.getGenero().equalsIgnoreCase("documental")){
            throw new IllegalStateException("Año incorrecto."); // acá podría poner algo mejor como una exception personalizada
        }

        Optional<Movie> movieOptional = movieRepository
                .findMovieByTitleAndDirector(movie.getTitle(), movie.getDirector());
        if(movieOptional.isPresent()){
            throw new IllegalStateException("Movie already exists.");
        }

    }

}
