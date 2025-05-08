package com.movies.demo.controller;

import com.movies.demo.model.Movie;
import com.movies.demo.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<?> crearPelicula(@Valid @RequestBody Movie movie){
        // no entiendo absolutamente nada de esta función en el archivo "Arquitectura MVC"
    }


    @GetMapping
    public List<Movie> listarTodasLasPeliculas(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return movieService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<Movie>> getByAnio(@PathVariable Integer anio){ // acá no pude usar <?>

        List<Movie> moviesAux = movieService.buscarPorAnio(anio);

        if(moviesAux.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(moviesAux);
    }

}
