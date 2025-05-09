package com.movies.demo.service;

import com.movies.demo.model.Movie;
import com.movies.demo.repository.MovieRepository;
import com.movies.demo.validations.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired // usar Autowired o no?
    private MovieRepository movieRepository;
    @Autowired
    private MovieValidator movieValidator;

    public Optional<Movie> saveMovie(Movie movie){

        movieValidator.validarParaCreacion(movie);


        return Optional.of(movieRepository.save(movie));
    }


    public Optional<Movie> getById(Long id){

        return movieRepository.findById(id); // findById ya devuelve un Optional
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> buscarPorAnio(Integer anio){
        return movieRepository.findByAnioLanzamiento(anio);
    }

}
