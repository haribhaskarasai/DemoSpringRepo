package com.stg.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.stg.entity.Cast;
import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;
import com.stg.repository.CastRepository;
import com.stg.repository.MovieRepository;
@Service
public class CastServiceImpl implements CastService {
	@Autowired
	private CastRepository castRepository;
	@Autowired
	private MovieRepository movieRepository;
	
	
	@Override
	public Cast addActortoNonExistingMovie(Cast actor) throws ExceptionClass {
		//Movie movie = movieRepository.findByMvId(movieId);
		//Cast actorTemp =actorRepository.findByActorId(actor.getActorId());
		Movie movie =actor.getMovies().get(0);
		movie.getActors().add(actor);
		movieRepository.save(movie);		
		return castRepository.save(actor);
		
		
	}

	@Override
	public Cast addActorToExcisitingMovie(Cast actor, String mvName, LocalDate releaseDate) throws ExceptionClass {
		Movie movie = movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		movie.getActors().add(actor);
		actor.getMovies().add(movie);
		return castRepository.save(actor);
	}

}




/*
 * if (actorTemp == null ) {
 * 
 * return actorRepository.save(actor); } else { throw new
 * ExceptionClass("That movie already exist"); }
 */