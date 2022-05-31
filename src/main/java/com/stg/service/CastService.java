package com.stg.service;

import java.time.LocalDate;


import com.stg.entity.Cast;

import com.stg.exception.ExceptionClass;

public interface CastService {
	public abstract Cast addActortoNonExistingMovie(Cast actor) throws ExceptionClass;
	public abstract Cast addActorToExcisitingMovie(Cast actor,String mvName,LocalDate releaseDate) throws ExceptionClass;
}
