package com.movies.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.Year;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100, message = "El titulo es necesario.")
    private String title;

    @NotBlank
    private String director;

    @Min(1895)
    @Max(value = Year.MAX_VALUE, message = "Año demsasiado grande")
    private int anioLanzamiento;

    private String genero;

    public Movie() {
    }

    public Movie(String title, String director, int anioLanzamiento, String genero) {
        this.title = title;
        this.director = director;
        this.anioLanzamiento = anioLanzamiento;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
