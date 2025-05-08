package com.movies.demo.service;

import com.movies.demo.model.Movie;
import com.movies.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired // usar Autowired o no?
    private MovieRepository movieRepository;


    public Optional<Movie> saveMovie(Movie movie){

        Optional<Movie> movieOptional = movieRepository
                .findMovieByTitleAndDirector(movie.getTitle(), movie.getDirector());
        if(movieOptional.isPresent()){
            throw new IllegalStateException("Movie already exists.");
        }

        if(movie.getAnioLanzamiento() < 1920 && movie.getGenero().equalsIgnoreCase("documental")){
            return Optional.empty();
        }

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
