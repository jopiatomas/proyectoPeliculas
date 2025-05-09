package com.movies.demo.validations;

import com.movies.demo.exceptions.AnioIncorrectoException;
import com.movies.demo.exceptions.PeliculaYaExisteException;
import com.movies.demo.model.Movie;
import com.movies.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MovieValidator {

    @Autowired
    private MovieRepository movieRepository;

    public void validarParaCreacion(Movie movie){
        if(movie.getAnioLanzamiento() < 1920 && movie.getGenero().equalsIgnoreCase("documental")){
            throw new AnioIncorrectoException("Año incorrecto."); // acá podría poner algo mejor como una exception personalizada
        }

        Optional<Movie> movieOptional = movieRepository
                .findMovieByTitleAndDirector(movie.getTitle(), movie.getDirector());
        if(movieOptional.isPresent()){
            throw new PeliculaYaExisteException("La pelicula ya existe.");
        }

    }

}
