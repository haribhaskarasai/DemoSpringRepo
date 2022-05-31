package com.stg.service;

import java.time.LocalDate;
import java.util.List;

import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;

public interface MovieService {
	public abstract Movie addMovie(Movie movie) throws ExceptionClass;
	public abstract Movie readByMovieId(int mvId) throws ExceptionClass;
	public abstract Movie readByMvNameAndReleaseDate(String mvName,LocalDate releaseDate) throws ExceptionClass;
	public abstract List<Movie> findAllMoviesByRatig(int mvRating);
	public abstract Movie updateByMvNameAndReleaseDate(Movie movie,String mvName,LocalDate releaseDate) throws ExceptionClass;
	
	public abstract String deleteByMvNameAndReleaseDate(String mvName,LocalDate releaseDate) throws ExceptionClass;
}
