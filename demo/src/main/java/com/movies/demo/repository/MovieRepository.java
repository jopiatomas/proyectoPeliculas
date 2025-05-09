package com.movies.demo.repository;

import com.movies.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface  MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findMovieByTitleAndDirector(String title, String director);
    List<Movie> findByAnioLanzamiento(Integer anio);

}
