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

import com.stg.entity.Cast;
import com.stg.service.CastServiceImpl;
@RestController
@RequestMapping(value = "Cast")
public class CastController {

	@Autowired
	public CastServiceImpl castServiceImpl;
	
	@PostMapping(value = "addActorToExistingMovie/{mvName}/{releaseDate}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cast addActorToExcisitingMovie(@RequestBody Cast actor,@PathVariable String mvName, @RequestParam("releaseDate") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    LocalDate releaseDate) {
		return castServiceImpl.addActorToExcisitingMovie(actor, mvName, releaseDate);

	}
	
	@PostMapping(value = "addActorToNewMovie", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cast addActorToNonExcisitingMovie(@RequestBody Cast actor) {
		return castServiceImpl.addActortoNonExistingMovie(actor);

	}

}
