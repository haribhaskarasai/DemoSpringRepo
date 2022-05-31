package com.stg.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Cast;
import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;
import com.stg.service.MovieService;
import com.stg.service.MovieServiceImpl;

@RestController
@RequestMapping(value = "Movie")
public class MovieController {
	@Autowired
	public MovieServiceImpl movieServiceImpl;

	@PostMapping(value = "addMv")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieServiceImpl.addMovie(movie);

	}

	@GetMapping(value = "readByMvId/{mvId}")
	public Movie readByMvId(@PathVariable int mvId) {
		return movieServiceImpl.readByMovieId(mvId);
	}
	
	
	@GetMapping(value = "readByMvNameAndReleaseDate/{mvName}/{releaseDate}")
	public Movie readByMvNameAndReleaseDate(@PathVariable String mvName, @RequestParam("releaseDate") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    LocalDate releaseDate) {
		return movieServiceImpl.readByMvNameAndReleaseDate(mvName, releaseDate);
	}
	
	@GetMapping(value = "readAllMoviesByMvRating/{mvRating}")
	public List<Movie> readByMvRating(@PathVariable int mvRating) {
		return movieServiceImpl.findAllMoviesByRatig(mvRating);
	}
	
	
	@PutMapping(value = "updateByMvNameAndReleaseDate/{mvName}/{releaseDate}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Movie updateMvByMvNameAndReleaseDate(@RequestBody Movie movie, @PathVariable String mvName, @RequestParam("releaseDate") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
		return movieServiceImpl.updateByMvNameAndReleaseDate(movie,mvName,releaseDate);
	}

	@DeleteMapping(value = "deleteByMvNameAndReleaseDate/{mvName}/{releaseDate}")
	public String deleteByMvNameAndReleaseDate(@PathVariable String mvName, @RequestParam("releaseDate") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
		return (movieServiceImpl.deleteByMvNameAndReleaseDate(mvName, releaseDate));
	}

	@ExceptionHandler(value = com.stg.exception.ExceptionClass.class)
	public String handleException(ExceptionClass exceptionClass) {
		return exceptionClass.getMessage();
	}

}
