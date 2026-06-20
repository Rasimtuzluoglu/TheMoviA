package com.raspel.movia.service;

import com.raspel.movia.dto.MovieDto;

import java.util.List;

public interface MovieService {

    MovieDto createMovie(MovieDto movieDto);

    List<MovieDto> getAllMovies();

    MovieDto getMovieById(Long id);

    MovieDto updateMovie(Long id, MovieDto movieDto);

    void deleteMovie(Long id);
}
