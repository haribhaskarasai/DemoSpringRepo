package com.stg.service;


import java.time.LocalDate;

import com.stg.entity.Cast;
import com.stg.entity.Crew;
import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;

public interface CrewService {
	public abstract Crew addTechToExisitingMovie(Crew technician,String mvName,LocalDate releaseDate) throws ExceptionClass;
	
	public abstract Crew addTechtoNonExistingMovie(Crew technician) throws ExceptionClass;
	
}
