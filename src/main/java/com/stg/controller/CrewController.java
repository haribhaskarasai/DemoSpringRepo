package com.stg.controller;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.stg.entity.Crew;
import com.stg.entity.Movie;
import com.stg.service.CrewServiceImpl;

@RestController
@RequestMapping(value = "Crew")
public class CrewController {
	@Autowired
	public CrewServiceImpl crewServiceImpl;
	
	@PostMapping(value = "addTechToExistingMovie/{mvName}/{releaseDate}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Crew addTechToExcisitingMovie(@RequestBody Crew technician,@PathVariable String mvName, @RequestParam("releaseDate") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    LocalDate releaseDate) {
		return crewServiceImpl.addTechToExisitingMovie(technician, mvName, releaseDate);

	}
	
	@PostMapping(value = "addTechToNonExistingMovie", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Crew addTechToNonExistingMovie(@RequestBody Crew technician) {
		return crewServiceImpl.addTechtoNonExistingMovie(technician);

	}
	
}
