package com.raspel.movia.service;

import com.raspel.movia.dto.MovieDto;
import com.raspel.movia.entity.Movie;
import com.raspel.movia.mapper.MovieMapper;
import com.raspel.movia.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Repository ve Mapper'ı otomatik bağlar (Constructor Injection)
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        // 1. DTO'yu veritabanına kaydedebilmek için Entity'ye çeviriyoruz
        Movie movie = movieMapper.toEntity(movieDto);
        
        // 2. Veritabanına kaydet
        Movie savedMovie = movieRepository.save(movie);
        
        // 3. Kaydedilen veriyi tekrar DTO olarak geri döndür
        return movieMapper.toDto(savedMovie);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film bulunamadı! ID: " + id));
        return movieMapper.toDto(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}