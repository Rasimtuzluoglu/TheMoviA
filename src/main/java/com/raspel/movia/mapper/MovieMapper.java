package com.raspel.movia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.raspel.movia.dto.MovieDto;
import com.raspel.movia.entity.Movie;

@Mapper(componentModel = "spring")
public interface MovieMapper {
 MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
 MovieDto tDto(Movie movie);
 Movie tEntity(MovieDto movieDto);
}
