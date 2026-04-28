package com.raspel.movia.service;

import java.util.List;

import com.raspel.movia.dto.MovieDto;

public interface MovieService {
    MovieDto createMovie (MovieDto movieDto);;
    List<MovieDto> getAllMovies();
    MovieDto getMovieById(Long id);
    void deleteMovieById(Long id);
}
