package com.raspel.movia.service.impl;

import com.raspel.movia.dto.MovieDto;
import com.raspel.movia.entity.Movie;
import com.raspel.movia.mapper.MovieMapper;
import com.raspel.movia.repository.MovieRepository;
import com.raspel.movia.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = movieMapper.tEntity(movieDto);
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.tDto(savedMovie);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::tDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film bulunamadı! ID: " + id));
        return movieMapper.tDto(movie);
    }

    @Override
    public MovieDto updateMovie(Long id, MovieDto movieDto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film bulunamadı! ID: " + id));
        movie.setTitle(movieDto.getTitle());
        movie.setType(movieDto.getType());
        movie.setRating(movieDto.getRating());
        movie.setRecommendedBy(movieDto.getRecommendedBy());
        movie.setNote(movieDto.getNote());
        movie.setRewatchable(movieDto.getRewatchable());
        Movie updatedMovie = movieRepository.save(movie);
        return movieMapper.tDto(updatedMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("Film bulunamadı! ID: " + id);
        }
        movieRepository.deleteById(id);
    }
}
