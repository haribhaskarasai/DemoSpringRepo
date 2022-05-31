package com.stg.service;

import java.time.LocalDate;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stg.entity.Crew;
import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;
import com.stg.repository.CrewRepository;
import com.stg.repository.MovieRepository;
@Service
public class CrewServiceImpl implements CrewService {
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private CrewRepository crewRepository;

	

	@Override
	public Crew addTechtoNonExistingMovie(Crew technician) throws ExceptionClass {
		Movie movie =technician.getMovies().get(0);
		movie.getCrews().add(technician);
		movieRepository.save(movie);
		
		return crewRepository.save(technician);
	}
	
	@Override
	public Crew addTechToExisitingMovie(Crew technician, String mvName, LocalDate releaseDate) throws ExceptionClass {
		Movie movie=movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		
		  movie.getCrews().add(technician);
		  technician.getMovies().add(movie);
		 
		
		return crewRepository.save(technician);
	}

	


	
	 

}
